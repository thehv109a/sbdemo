Vue.component('paginate', VuejsPaginate);
Vue.component('v-select', VueSelect.VueSelect);
var router = new VueRouter({ mode: 'history', routes: [] });
var userInfo = new Vue({ el: '#userInfo', data: { authName: getCookie("authName") } });

function currentDateStr() {
    return new Date().toISOString().slice(0, 10);
}

function before1DayCurrentDateStr() {
    var date = new Date();
    date.setDate(date.getDate() - 1);
    return date.toISOString().slice(0, 10)
}

function getDateStrWithCurrentDate(day) {
    var date = new Date();
    date.setDate(date.getDate() - day);
    return date.toISOString().slice(0, 10)
}

function greaterOrEqualCurrentDateStr(dateStr) {
    return (currentDateStr(dateStr) || new Date(dateStr).getTime() - new Date().getTime() > 0) ? true : false;
}

function nextDateStr(dateStr) {
    var date = new Date(dateStr);
    date.setDate(date.getDate() + 1);
    return date.toISOString().slice(0, 10);
}

function dateRageIsValid(fromDate, toDate) {
    if (fromDate == null || toDate == null) {
        alert("Bạn phải chọn ngày bắt đầu và ngày kết thúc"); return false;
    }
    if (new Date(fromDate).getTime() < 1583712000000) {
        alert("Ngày bắt đầu phải từ ngày 09/03/2020"); return false;
    }
    if ((new Date(toDate) - new Date(fromDate)) < 0 || (new Date(toDate) - new Date(fromDate) > 60 * 86400000)) {
        alert("Ngày kết thúc phải lớn hơn ngày bắt đầu không quá 60 ngày"); return false;
    }
    return true;
}

function formatRatio(number) {
    return number.toFixed(2);
}

function formatDate(sqlDate) {
    if (sqlDate == null || sqlDate == "") return "-"
    return sqlDate.substring(8, 10) + '/' + sqlDate.substring(5, 7) + '/' + sqlDate.substring(0, 4);
}

function convertNumberToString(number) {
    if (typeof (number) === "number") {
        number = number.toString().indexOf("-") > -1 ? 0 : number
        number = number.toString().indexOf(".") > -1 ? number.toString().split(".")[0] : number;
        return number.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
    } else {
        return number;
    }
}

function getFirstDateOfMonth() {
    var date = new Date();
    var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
    var firstDayWithSlashes = firstDay.getFullYear() + '-' + (firstDay.getMonth() + 1) + '-' + (firstDay.getDate());
    return firstDayWithSlashes
}

function getLastDateOfMonth() {
    var date = new Date();
    var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    var lastDayWithSlashes = lastDay.getFullYear() + '-' + (lastDay.getMonth() + 1) + '-' + (lastDay.getDate());
    return lastDayWithSlashes
}

function toXls(fileName) {
    var uri = 'data:application/vnd.ms-excel;base64,',
        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64 = function (s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        },
        format = function (s, c) {
            return s.replace(/{(\w+)}/g, function (m, p) {
                return c[p];
            })
        }
    var toExcel = document.getElementById("toExcel").innerHTML;
    var ctx = {
        worksheet: name || '',
        table: toExcel
    };
    var link = document.createElement("a");
    link.download = fileName + new Date().toISOString().slice(0, 10) + ".xls";
    link.href = uri + base64(format(template, ctx))
    link.click();
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}