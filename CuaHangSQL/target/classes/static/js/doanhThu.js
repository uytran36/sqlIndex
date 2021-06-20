function submitFunc() {
    let month = document.getElementById("month").value;
    let year = document.getElementById("year").value;

    let url = "http://localhost:8080/doanhthu/" + month + "/" + year + "/1"
    window.location.replace(url);
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