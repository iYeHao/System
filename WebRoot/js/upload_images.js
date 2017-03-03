// MultiUploader.fla
import flash.net.FileReferenceList;
import flash.net.FileReference;
import flash.external.ExternalInterface;

// 设置as中函数和js调用时的映射关系
ExternalInterface.addCallback("fu_open_dialog", null, openDialog);
ExternalInterface.addCallback("fu_begin_upload", null, beginUpload);

// 可以通过html页面里边设置FlashVars里边的upload_url来更改上传文件的路径
var uploadUrl = typeof(_root.upload_url) == "undefined" ? "FlashUpload.ashx" : _root.upload_url;
var listener = new Object();
// 选择文件后，会视图调用js函数onUploaderSelect，并将文件列表传入进去，便于js进一步做一些逻辑控制
listener.onSelect = function(fileRefList:FileReferenceList) {
    ExternalInterface.call("onUploaderSelect", fileRefList.fileList); 
};

var fileRefList:FileReferenceList = null;
var imageTypes:Object = new Object();
imageTypes.description = "Images (*.jpg, *.jpeg, *.gif, *.png)"; // 上传文件类型说明
imageTypes.extension = "*.jpg; *.jpeg; *.gif; *.png"; // 控制上传文件类型

// 显示文件打开窗口
function openDialog():Void {
    if (fileRefList == null) {
        fileRefList = new FileReferenceList();
        fileRefList.addListener(listener);
    }
    fileRefList.browse([imageTypes]);
}
// 开始上传
function beginUpload():Void {
    var lis = new Object();
    // 每上传完一个文件后调用js函数onUploaderComplete
    lis.onComplete = function(file:FileReference):Void {
        ExternalInterface.call("onUploaderComplete", file.name); 
    };
    // 处理上传地址的http状态错误。比如404等。
    lis.onHTTPError = function(file:FileReference, httpError: Number):Void {
        ExternalInterface.call("onUploaderHTTPError", httpError, file.name);
    }
    
    var list:Array = fileRefList.fileList;
    var item:FileReference;
    // 最终还是将文件分单次传到指定上传页面进行处理
    for(var i:Number = 0; i < list.length; i++) {
        item = list[i];
        item.addListener(lis);
        item.upload(uploadUrl);
    }
}