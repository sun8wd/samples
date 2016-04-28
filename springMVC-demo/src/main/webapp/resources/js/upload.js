$(document).ready(function() {
	var uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'uploadBtn',
		url : "/springMVC-demo/files/upload",
		// Maximum file size
		chunk_size : '1mb',
		// Specify what files to browse for
		filters : {
			max_file_size : '3gb',
			prevent_duplicates : true, //不允许选取重复文件
			mime_types : [ {
				title : "bam",
				extensions : "bam"
			}, {
				title : "ab1",
				extensions : "ab1"
			}, {
				title : "abi",
				extensions : "abi"
			}, {
				title : "fasta",
				extensions : "fasta"
			}, {
				title : "fastq",
				extensions : "fastq"
			}, {
				title : "tsv",
				extensions : "tsv"
			}, {
				title : "gz",
				extensions : "gz"
			}, {
				title : "pdf",
				extensions : "pdf"
			},
			{
				title : "dmg",
				extensions : "dmg"
			}]
		},
		max_retries : 5,
		multiple_queues : true,
		// Flash settings
		flash_swf_url : '/plupload-2.1.8/js/Moxie.swf',
		// Silverlight settings
		silverlight_xap_url : '/plupload-2.1.8/js/Moxie.xap'
	});
	uploader.init();
	uploader.bind("QueueChanged", function(up) {
	});
	uploader.bind("UploadProgress", function(uploader, file) {
		$("#" + file.id +" .percent").html(file.percent+"%");
		$("#" + file.id +" .spead").html(getSpead(uploader.total.bytesPerSec));
	});
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
	uploader.bind("FilesAdded", function(uploader, files) {
		$.each(files, function(index, item) {
			var $fileDom = $('<tr id="' + item.id + '"></tr>');
			$fileDom.append($('<td class="filename">' + item.name + '</td>'));
			$fileDom.append($('<td class="md5">---</td>'));
			$fileDom.append($('<td class="percent" align="right">0%</td>'));
			$fileDom.append($('<td class="size" align="right">'+getSize(item.size)+'</td>'));
			$fileDom.append($('<td class="spead" align="right">---</td>'));
			$("#uploader").append($fileDom);
			var params = {"size":item.size,"lastModifiedDate":item.lastModifiedDate,"name":item.name};
			$.get("/springMVC-demo/files/checkBreakpoints",params,function(data){
				if(data.loaded){
					item.loaded = data.loaded;
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
	});
	uploader.bind("BeforeUpload", function(uploader, file) {
		 uploader.setOption("multipart_params",{"size":file.size,"lastModifiedDate":file.lastModifiedDate});
	});
	uploader.bind("Error", function(uploader, error) {
		 if(error.code=='-602'){
			 alert("当前队列已存在文件【"+error.file.name+"】，请勿重复添加！");
		 }
	});
	
});