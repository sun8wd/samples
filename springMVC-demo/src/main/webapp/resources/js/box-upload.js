$(document).ready(function() {
	var uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'uploadBtn',
		url : "http://localhost:9090/box/upload",
		// Maximum file size
		chunk_size : '1mb',
		// Specify what files to browse for
		filters : {
			max_file_size : '3gb',
			prevent_duplicates : true, //不允许选取重复文件
			mime_types : [ ]
		},
		max_retries : 5,
		multiple_queues : true,
		// Flash settings
		flash_swf_url : contextPath+'/plugin/plupload-2.1.8/js/Moxie.swf',
		// Silverlight settings
		silverlight_xap_url : contextPath+'/plugin/plupload-2.1.8/js/Moxie.xap'
	});
	uploader.init();
	uploader.bind("QueueChanged", function(up) {
	});
	uploader.bind("UploadProgress", function(uploader, file) {
		$("#" + file.id +" .percent").html(file.percent+"%");
		$("#" + file.id +" .spead").html(getSpead(uploader.total.bytesPerSec));
		var $state = $("#"+file.id+" .state");
		$state.attr("title","正在从本地往盒子上传");
		$state.html("上传中");
	});
	function getSize(fileSize){
		if(!fileSize){
			return "";
		}
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
	uploader.bind("FilesAdded", function(uploader, files) {
		$.each(files, function(index, item) {
			var $fileDom = $('<tr id="' + item.id + '"></tr>');
			$fileDom.append($('<td class="filename">' + item.name + '</td>'));
			$fileDom.append($('<td class="md5">---</td>'));
			$fileDom.append($('<td class="percent" align="right"></td>'));
			$fileDom.append($('<td class="size" align="right">'+getSize(item.size)+'</td>'));
			$fileDom.append($('<td class="spead" align="right">---</td>'));
			$fileDom.append($('<td class="state" align="center">等待上传</td>'));
			$("#uploader").append($fileDom);
			var params = {"size":item.size,"lastModifiedDate":item.lastModifiedDate,"name":item.name};
			$.get("http://localhost:9090/box/checkBreakpoints",params,function(data){
				if(data.data){
					item.loaded = data.data;
					$("#" + item.id +" .percent").html((item.loaded/item.size).toFixed(2)*100+"%");
				}
			});
		}); 
	});
	$("#startUpload").click(function(){
		uploader.start();
	});
	uploader.bind("FileUploaded", function(uploader, file, response) {
		var res = JSON.parse(response.response);
		if(res.md5){
			$("#" + file.id +" .md5").html(res.md5);
		}
		if(res.success){
			var $state = $("#"+file.id+" .state");
			$state.attr("title","正在从盒子往远程服务器同步");
			$state.html("同步中");
			$.get(contextPath+"/box/sync",{id:res.id},function(data){
				$state.html("完成");
				$state.removeAttr("title");
			});
		}
	});
	uploader.bind("BeforeUpload", function(uploader, file) {
		 uploader.setOption("multipart_params",{"size":file.size,"lastModifiedDate":new Date(file.lastModifiedDate),"userId":12});
	});
	uploader.bind("Error", function(uploader, error) {
		 if(error.code=='-602'){
			 alert("当前队列已存在文件【"+error.file.name+"】，请勿重复添加！");
		 }
	});
});