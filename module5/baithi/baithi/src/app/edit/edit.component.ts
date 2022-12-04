import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {VexeService} from "../vexe.service";
import {Nhaxe} from "../model/garage";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Vexe} from "../model/ticket";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  nhaXes: Nhaxe[] = [];
  formEditVeXe: FormGroup;
  message: string;
  id: number;
  veXeForm: Vexe;

  equals(o1: Nhaxe, o2: Nhaxe) {
    return o1.id === o2.id;
  }

  constructor(private vexeService: VexeService,
              private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.editForm();
    this.getNhaXe();

  }

  editForm() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      console.log(this.id);
      this.vexeService.findById(this.id).subscribe(data => {
        this.veXeForm = data;
        this.formEditVeXe = this.formBuilder.group({
          giaVe: [this.veXeForm.giaVe,
            [Validators.required,
              Validators.pattern("^\\d+$")]],
          diemDi: [this.veXeForm.diemDi,
            [Validators.required]],
          diemDen: [this.veXeForm.diemDen,
            [Validators.required]],
          ngayKhoiHanh: [this.veXeForm.ngayKhoiHanh,
            [Validators.required]],
          gioKhoiHanh: [this.veXeForm.gioKhoiHanh,
            [Validators.required,
              Validators.pattern("[0-9]{2}(:)[0-9]{2}")]],
          nhaXe: [this.veXeForm.nhaXe,
            [Validators.required]],
          soLuong: [this.veXeForm.soLuong,
            [Validators.required,
              Validators.pattern("^\\d+$")]]
        })
      })
    })
  }

  getNhaXe() {
    this.vexeService.findAllNhaXe().subscribe(data => {
      this.nhaXes = data;
    })
  }

  suaVeXe(id: number) {
    if (this.formEditVeXe.valid) {
      this.vexeService.update(id, this.formEditVeXe.value).subscribe(data => {
        this.router.navigateByUrl("/vexe")
      });
    }
    this.message = "Sửa thất bại"
  }
}
