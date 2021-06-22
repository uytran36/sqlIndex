package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Repository.CtHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtHoaDonService {
    @Autowired
    private CtHoaDonRepository ctHoaDonRepository;

    public void saveAllCtHD(List<CtHoaDon> ctHoaDonList) {
        ctHoaDonRepository.saveAll(ctHoaDonList);
    }
}
