package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {
    private int id;
    @NotBlank(message = "Không để trống")
    private String name;
    @NotBlank(message = "Không để trống")
    private String singer;
    @NotBlank(message = "Không để trống")
    private String typeOfSong;

    public SongDTO() {
    }

    public SongDTO(int id, String name, String singer, String typeOfSong) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.typeOfSong = typeOfSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfSong() {
        return typeOfSong;
    }

    public void setTypeOfSong(String typeOfSong) {
        this.typeOfSong = typeOfSong;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        if (!songDTO.name.matches("^[A-Za-zàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$") && !songDTO.name.equals("")) {
            errors.rejectValue("name", "name.errors", "Tên bài hát không hợp lệ");
        }
        if (!songDTO.singer.matches("^[A-Za-z1-9àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,300}$") && !songDTO.singer.equals("")) {
            errors.rejectValue("singer", "singer.errors", "Tên nghệ sĩ không hợp lệ");
        }
        if (!songDTO.typeOfSong.matches("^[A-Za-z1-9àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ, ]{3,1000}$") && !songDTO.typeOfSong.equals("")) {
            errors.rejectValue("typeOfSong", "type.errors", "Thể loại nhạc không hợp lệ");
        }
    }
}
