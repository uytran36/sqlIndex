function addHoaDon() {
    if (document.getElementById("ngayLap") == null || document.getElementById("maKH")) {
        alert("Vui lòng nhập đủ thông tin")
    }
}

function doiMaHoaDon() {
    document.getElementById("maHD").readOnly = false;

}