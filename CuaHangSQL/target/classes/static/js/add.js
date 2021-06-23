function addHoaDon() {
    if (document.getElementById("ngayLap") == null || document.getElementById("maKH")) {
        alert("Vui lòng nhập đủ thông tin")
    }
    else {
        var maSP = document.getElementById("maSP").value
        var soLuong = document.getElementById("soLuong").value
        var giaBan = document.getElementById("giaBan").value
        var giaGiam = document.getElementById("giaGiam").value
        var tr = document.createElement("tr")
        tr.id = 'row-' + count;

        var td1 = document.createElement("td")
        td1.setAttribute("name", "maSP")
        td1.id = 'maSP-' + count;
        td1.innerHTML = maSP

        var td2 = document.createElement("td")
        td2.setAttribute("name", "soLuong")
        td2.innerHTML = soLuong
        td2.id = 'soLuong-' + count;

        var td3 = document.createElement("td")
        td3.setAttribute("name", "giaBan")
        td3.innerHTML = giaBan
        td3.id = 'giaBan-' + count;

        var td4 = document.createElement("td")
        td4.setAttribute("name", "giaGiam")
        td4.innerHTML = giaGiam
        td4.id = 'giaGiam-' + count;

        tr.appendChild(td1)
        tr.appendChild(td2)
        tr.appendChild(td3)
        tr.appendChild(td4)

        document.getElementById("ctHoaDon").appendChild(tr)

        document.getElementById("maSP").value = ''
        document.getElementById("soLuong").value = ''
        document.getElementById("giaBan").value = ''
        document.getElementById("giaGiam").value = ''
        count = count + 1
    }
}

function submitCtHD() {
    let tong = 0;
    for (let i = 1; i <= count; i++) {
        var ban = document.getElementById("giaBan-" + i).value;
        var giam = document.getElementById("giaGiam-" + i).value;
        var soLuong = document.getElementById("soLuong-" + i).value;
        tong += (ban - giam) * soLuong;
    }
    document.getElementById("tongTien").innerHTML = tong.toString();
}
