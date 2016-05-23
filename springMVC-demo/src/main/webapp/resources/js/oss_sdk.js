(function(){
	/**
	 * Creates new cookie or removes cookie with negative expiration
	 * 
	 * @param key
	 *            The key or identifier for the store
	 * @param value
	 *            Contents of the store
	 * @param exp
	 *            Expiration - creation defaults to 30 days
	 */
	function createCookie(key, value, exp) {
	    var date = new Date();
	    date.setTime(date.getTime() + (exp * 24 * 60 * 60 * 1000));
	    var expires = "; expires=" + date.toGMTString();
	    document.cookie = key + "=" + value + expires + "; path=/";
	}

	/**
	 * Returns contents of cookie
	 * 
	 * @param key
	 *            The key or identifier for the store
	 */
	function readCookie(key) {
	    var nameEQ = key + "=";
	    var ca = document.cookie.split(';');
	    for (var i = 0, max = ca.length; i < max; i++) {
	        var c = ca[i];
	        while (c.charAt(0) === ' ') {
	            c = c.substring(1, c.length);
	        }
	        if (c.indexOf(nameEQ) === 0) {
	            return c.substring(nameEQ.length, c.length);
	        }
	    }
	    return null;
	}

	// if current browser is not support localStorage
	// use cookie to make a polyfill
	if ( !window.localStorage ) {
	    window.localStorage = {
	        setItem: function (key, value) {
	            createCookie(key, value, 30);
	        },
	        getItem: function (key) {
	            return readCookie(key);
	        },
	        removeItem: function (key) {
	            createCookie(key, '', -1);
	        }
	    };
	}
})();

var oss = (function(oss){
	var self = oss||{};
	var client = new OSS.Wrapper({
		region : 'oss-cn-shanghai',
		accessKeyId : 'H4o9XLSLEg8rJFiH',
		accessKeySecret : 'tkIXuA5qY2OAomH0w5K3JgKVnu1FTg',
		bucket : 'sun8wd'
	});
	self.list = function(){
		$("#allFileList").html("");
		client.list({
			'max-keys': 10
		}).then(function (result) {
			var objects = result.objects.sort(function (a, b) {
				var ta = new Date(a.lastModified);
				var tb = new Date(b.lastModified);
				if (ta > tb) return -1;
				if (ta < tb) return 1;
				return 0;
			});
			$.each(objects,function(index,item){
				var $fileDom = $('<tr id="' + createId(item) + '"></tr>');
				$fileDom.append($('<td class="filename"><a href="'+item.url+'" target="_blank">' + item.name + '</a></td>'));
				$fileDom.append($('<td class="etag" align="left">'+item.etag+'</td>'));
				var lastModified = new Date(item.lastModified).toLocaleString();
				$fileDom.append($('<td class="lastModified" align="center">'+lastModified+'</td>'));
				$fileDom.append($('<td class="size" align="right">'+getSize(item.size)+'</td>'));
				$("#allFileList").append($fileDom);
			});
		}).catch(function (err) {
			console.log(err);
		});
	};
	var fileProgress = {};
	var progress = function (p,ckp) {
		return function (done) {
			if(ckp){
				localStorage.setItem(createId(ckp.file),JSON.stringify(ckp));
				$("#" + createId(ckp.file) +" .upload_progress").html((p*100).toFixed(2)+"%");
			}
			done();
		}
	};
	
	$(document).on("change","#file",function(e){
		var $self = $(this);
		var files = e.target.files;
		if(!files||files.length<=0){
			console.log("未选择文件！");
			return;
		}
		$self.attr("disabled","disabled");
		for(var i=0;i<files.length;i++){
			var file =files[i];
			var fileId = createId(file);
			var $fileDom = $("#"+fileId);
			if($fileDom.length==0){
				$fileDom = $('<tr id="' + fileId + '"></tr>');
			}
			$fileDom.html('');
			$fileDom.append($('<td class="filename">' + file.name + '</td>'));
			$fileDom.append($('<td class="upload_progress" align="right">0%</td>'));
			$fileDom.append($('<td class="size" align="right">'+getSize(file.size)+'</td>'));
			$fileDom.append($('<td class="spead" align="right">---</td>'));
			$("#uploader").append($fileDom);
			var option = {progress:progress};
			var ckp = localStorage.getItem(createId(file));
			console.log(ckp);
			if(ckp){
				ckp = JSON.parse(ckp);
				ckp.file=file;
				option.checkpoint=ckp;
			}
			client.multipartUpload(file.name,file,option).then(function(result){
				console.log(result);
				$self.removeAttr("disabled");
			}).catch(function(err){
				console.log(err);
				$self.removeAttr("disabled");
			});
		}
	});
	function createId(file){
		var size=file.size||file.fileSize;
		var time = new Date(file.lastModified).getTime();
		return md5Util.calc(file.name+file.size+time);
	}
	$("#listAll").click(function(){
		$("#allFilesModal").modal("show");
		self.list();
	});
	return self;
})(oss);
function getSize(fileSize){
	var unit = "b";
	if(fileSize > 1000){
		fileSize= fileSize / 1000;
		unit = "kb";
	}
	if(fileSize > 1000){
		fileSize= fileSize / 1000;
		unit = "mb";
	}
	return fileSize.toFixed(2)+unit;
}
function getSpead(spead){
	var unit = "b/s";
	if(spead > 1000){
		spead = spead/1000;
		unit = "kb/s";
	}
	if(spead > 1000){
		spead = spead/1000;
		unit = "mb/s";
	}
	return spead.toFixed(2)+unit;
}