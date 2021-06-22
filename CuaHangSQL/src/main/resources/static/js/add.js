var count = 0;

function addHoaDon() {
    if (document.getElementById("maSP").value === ''
        || document.getElementById("soLuong").value === ''
        || document.getElementById("giaBan").value === ''
        || document.getElementById("giaGiam").value === '') {
        alert("Xin hay nhap day du thong tin")
    }
    else if (parseInt(document.getElementById("giaBan").value)
        < parseInt(document.getElementById("giaGiam").value)) {
        alert("Gia ban phai cao hon gia giam")
    }
    else {
        count++
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
    }
}



function submitCtHD() {
    var tong = 0;
    var check = 0;
    while (count > 0) {
        var ban = parseInt(document.getElementById("giaBan-" + count).innerText);
        var giam = parseInt(document.getElementById("giaGiam-" + count).innerText);
        var soLuong = parseInt(document.getElementById("soLuong-" + count).innerText);
        tong += (ban - giam) * soLuong;
        count--
        check++
    }


    count = check;
    console.log(tong);
    var tongTien = document.getElementById("tongTien");
    tongTien.value = tong;
}

function getCTHDValues(){
    var maSP = document.getElementById("maSP-1").value;
    var soLuong = document.getElementById("soLuong-1").value;
    var giaBan = document.getElementById("giaBan-1").value;
    var giaGiam = document.getElementById("giaGiam-1").value;
    var result = maSP + "/" + soLuong + "/" + giaBan + "/" + giaGiam;
    return result;
}
