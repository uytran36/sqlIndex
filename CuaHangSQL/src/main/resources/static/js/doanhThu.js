function submitFunc() {
    let month = parseInt(document.getElementById("month").value);
    let year = parseInt(document.getElementById("year").value);

    if(year === 2020 && month > 4) {
        let url = "http://localhost:8080/doanhthu/" + month + "/" + year + "/1"
        window.location.replace(url);
    }
    if(year === 2021 && month < 7) {
        let url = "http://localhost:8080/doanhthu/" + month + "/" + year + "/1"
        window.location.replace(url);
    }
}

function prevFunc() {
    let pageStr = window.location.href.substring(window.location.href.lastIndexOf('/') + 1)
    let page = parseInt(pageStr);
    if(page > 1) {
        let temp = page - 1;
        let url = window.location.href.slice(0, window.location.href.lastIndexOf('/')) + '/' + temp.toString();
        window.location.replace(url);
    }
}

function nextFunc() {
    let pageStr = window.location.href.substring(window.location.href.lastIndexOf('/') + 1)
    let page = parseInt(pageStr);
    if(page < 500) {
        let temp = page + 1;
        let url = window.location.href.slice(0, window.location.href.lastIndexOf('/')) + '/' + temp.toString();
        window.location.replace(url);
    }
}