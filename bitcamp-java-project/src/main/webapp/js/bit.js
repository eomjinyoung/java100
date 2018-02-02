//bit.js
var bit = {};

bit.toQueryString = (obj) => {
    var qs = '';
    for (var propName in obj) {
        if (qs.length > 0) qs += '&';
        
        qs += propName + '=' + obj[propName]
    }
    return qs;
};

bit.ajax = (url, settings) => {
    
    if (settings == undefined) settings = {};
    if (settings.method == undefined) settings.method = 'GET';
    if (settings.data == undefined) settings.data = {};
    if (settings.dataType == undefined) settings.dataType = 'text';
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState < 4) return;
        if (xhr.status != 200) {
            if (settings.error) {
                settings.error();
            }
            return;
        }
        
        if (settings.success) {
            if (settings.dataType == 'json') {
                settings.success(JSON.parse(xhr.responseText));
            } else {
                settings.success(xhr.responseText);
            }
        }
    };
    
    xhr.open(settings.method, url, true);
    if (settings.method.toUpperCase() == 'POST') {
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send(bit.toQueryString(settings.data));
        
    } else { // GET, HEAD 요청
        xhr.send();
    }
};















