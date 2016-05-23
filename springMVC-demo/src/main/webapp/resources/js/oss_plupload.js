
accessid= 'H4o9XLSLEg8rJFiH';
accesskey= 'tkIXuA5qY2OAomH0w5K3JgKVnu1FTg';
host = 'http://sun8wd.oss-cn-shanghai.aliyuncs.com';

g_dirname = ''
g_object_name = ''
g_object_name_type = ''
now = timestamp = Date.parse(new Date()) / 1000; 

var policyText = {
    "expiration": "2020-01-01T12:00:00.000Z", // 设置该Policy的失效时间，超过这个失效时间之后，就没有办法通过这个policy上传文件了
    "conditions": [
    ["content-length-range", 0, 1048576000] // 设置上传文件的大小限制
    ]
};

var policyBase64 = Base64.encode(JSON.stringify(policyText))
message = policyBase64
var bytes = Crypto.HMAC(Crypto.SHA1, message, accesskey, { asBytes: true }) ;
var signature = Crypto.util.bytesToBase64(bytes);

function check_object_radio() {
    var tt = document.getElementsByName('myradio');
    for (var i = 0; i < tt.length ; i++ )
    {
        if(tt[i].checked)
        {
            g_object_name_type = tt[i].value;
            break;
        }
    }
}

function get_dirname()
{
    dir = document.getElementById("dirname").value;
    if (dir != '' && dir.indexOf('/') != dir.length - 1)
    {
        dir = dir + '/'
    }
    // alert(dir)
    g_dirname = dir
}

function random_string(len) {
　　len = len || 32;
　　var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';   
　　var maxPos = chars.length;
　　var pwd = '';
　　for (i = 0; i < len; i++) {
    　　pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function get_suffix(filename) {
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

function calculate_object_name(filename)
{
    if (g_object_name_type == 'local_name')
    {
        g_object_name += "${filename}"
    }
    else if (g_object_name_type == 'random_name')
    {
        suffix = get_suffix(filename)
        g_object_name = g_dirname + random_string(10) + suffix
    }
    return ''
}

function get_uploaded_object_name(filename)
{
    if (g_object_name_type == 'local_name')
    {
        tmp_name = g_object_name
        tmp_name = tmp_name.replace("${filename}", filename);
        return tmp_name
    }
    else if(g_object_name_type == 'random_name')
    {
        return g_object_name
    }
}

function set_upload_param(up, filename, ret)
{
    new_multipart_params = {
        'key' : filename,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid, 
        'success_action_status' : '200', // 让服务端返回200,不然，默认会返回204
        'signature': signature,
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });
}

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'uploadBtn', 
    // multi_selection: false,
	flash_swf_url : contextPath+'plugin/plupload-2.1.8/js/Moxie.swf',
	silverlight_xap_url : contextPath+'plugin/plupload-2.1.8/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',

	init: {
		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				var $fileDom = $('<tr id="' + file.id + '"></tr>');
				$fileDom.append($('<td class="filename">' + file.name + '</td>'));
				$fileDom.append($('<td class="etag">---</td>'));
				$fileDom.append($('<td class="percent" align="right"></td>'));
				$fileDom.append($('<td class="size" align="right">'+plupload.formatSize(file.size)+'</td>'));
				$fileDom.append($('<td class="spead" align="right">---</td>'));
				$("#uploader").append($fileDom);
			});
		},

		BeforeUpload: function(up, file) {
            set_upload_param(up, file.name, true);
        },

		UploadProgress: function(up, file) {
			$("#" + file.id +" .percent").html(file.percent+"%");
			$("#" + file.id +" .spead").html(getSpead(uploader.total.bytesPerSec));
		},

		FileUploaded: function(up, file, response) {
            if (response.status == 200)
            {
            	console.log(response);
            	$("#" + file.id +" .etag").html(response.responseHeaders.substr(5,response.responseHeaders.length));
            }
		},

		Error: function(up, err) {
			document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
		}
	}
});
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
uploader.init();
$("#startUpload").click(function(){
	uploader.start();
});
