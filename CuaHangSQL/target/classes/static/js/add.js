let count = 1;

function addHoaDon() {
    if (document.getElementById("maSP").value === ''
        || document.getElementById("soLuong").value === ''
        || document.getElementById("giaBan").value === ''
        || document.getElementById("giaGiam").value === '') {
        alert("Xin hay nhap day du thong tin")
    }
    else if (document.getElementById("giaBan").value < document.getElementById("giaGiam").value) {
        alert("Gia ban phai cao hon gia giam")
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
        td1.innerHTML = maSP
        var td2 = document.createElement("td")
        td2.setAttribute("name", "soLuong")
        td2.innerHTML = soLuong
        var td3 = document.createElement("td")
        td3.setAttribute("name", "giaBan")
        td3.innerHTML = giaBan
        var td4 = document.createElement("td")
        td4.setAttribute("name", "giaGiam")
        td4.innerHTML = giaGiam

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