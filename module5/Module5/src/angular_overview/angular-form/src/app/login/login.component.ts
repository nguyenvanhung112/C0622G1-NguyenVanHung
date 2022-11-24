import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup;
  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formLogin = this._formBuilder.group({
      email:[,[
        Validators.required,
        Validators.pattern("\\w+[@]\\w+[.]\\w+")]
      ],
      password:[
        ,[Validators.required,
        Validators.minLength(6)
      ]]
    })
  }

  login() {
    if (this.formLogin.valid){
      console.log(this.formLogin.value)
    }
  }
}
