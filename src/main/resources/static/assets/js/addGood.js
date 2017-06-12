var arr = [];

$(function () {
    if(typeof FileReader == 'undefined') {
        alert("当前浏览器不支持FileReader接口")
    }

    $.ajax({
        url: './catogary/getCatogary',
        success: function (data) {
            arr = data;
            var selector1 = $('select.form-control')[1];
            console.log(data);
            setCatogary(selector1,data);
            var selector2 = $('select.form-control')[2];
            setCatogary(selector2,data[0].smallCatogaryList);
        }
    })
})

function uploadImg(obj) {
    var file = obj.files[0];
    console.log(obj);
    console.log(file + file.size);
    var reader = new FileReader();
    reader.onload = function (e) {
        console.log("读取成功...");
        var img = $(obj).siblings('img')[0];
        img.src = e.target.result;
    }
    reader.readAsDataURL(file);
}

function addTab() {
    var item = '<tr class="template-upload fade in"><td>'+
        '<label>标签名：</label><input type="text" class="form-control" style="width: 200px;height: 50px" name="tabName" required></td><td><label>价格：</label><input name="tabPrice" type="number" class="form-control" min="0" style="width: 100px; height: 50px" required/></td><td><label>库存量：</label><input name="tabNum" type="number" class="form-control" min="0" style="width: 60px; height: 50px" required/></td><td>'+
        '<input type="file" name="tab" multiple onchange="uploadTab(this);" style="width:200px;"><img src="" alt="" style="width: 100px;height: 100px;display: none"></td>'+
        '<td><button type="button" class="btn red cancel" onclick="deleteTab(this);">'+
        '<i class="fa fa-ban"></i><span>Cancel</span></button></td></tr>';
    $('#tabList').append(item);
}

function deleteTab(obj) {
    console.log(obj);
    $(obj).parent().parent().remove();
}

function uploadTab(obj) {
    uploadImg(obj);
    $($(obj).siblings('img')[0]).show();
}

function changeSmallCatogary(val) {
    console.log(arr);
    var select2 = $('select.form-control')[2];
    var j;
    for(var i=0;i<arr.length;i++) {
        if(val.value == arr[i].id) {
           j = i;
            break;
        }
    }
    console.log(j)
    setCatogary(select2,arr[j].smallCatogaryList);
}

function setCatogary(obj,data) {
    $(obj).empty();
    for(var i=0;i<data.length;i++) {
        var option = document.createElement('option');
        option.value = data[i].id;
        option.innerHTML = data[i].name;
        obj.append(option);
    }
}