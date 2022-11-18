package com.example.bai_thi.controller;

import com.example.bai_thi.dto.DonHangDTO;
import com.example.bai_thi.model.DonHang;
import com.example.bai_thi.model.LoaiSanPham;
import com.example.bai_thi.model.SanPham;
import com.example.bai_thi.service.IDonHangService;
import com.example.bai_thi.service.ILoaiSanPhamService;
import com.example.bai_thi.service.ISanPhamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    IDonHangService donHangService;

    @Autowired
    ILoaiSanPhamService loaiSanPhamService;

    @Autowired
    ISanPhamService sanPhamService;

    @ModelAttribute("loaiSanPhamList")
    public List<LoaiSanPham> getListLoaiSanPham() {
        return loaiSanPhamService.getListLoaiSanPham();
    }

    @ModelAttribute("sanPhamList")
    public List<SanPham> getListSanPham() {
        return sanPhamService.getListSanPham();
    }

    @GetMapping
    public ModelAndView getList(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("donHangList", donHangService.findListDonHang(pageable));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        DonHang donHang = donHangService.findListDonHangById(id);
        DonHangDTO donHangDTO = new DonHangDTO();
        BeanUtils.copyProperties(donHang, donHangDTO);
        modelAndView.addObject("donHangDTO", donHangDTO);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute DonHangDTO donHangDTO, BindingResult bindingResult) {
        DonHang donHang = new DonHang();
        BeanUtils.copyProperties(donHangDTO, donHang);
        donHangService.save(donHang);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("donHangDTO", donHangDTO);
        modelAndView.addObject("message", "Update thành công!");
        return modelAndView;
    }
}
