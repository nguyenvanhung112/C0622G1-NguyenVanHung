import {Component, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from "@angular/forms";

// @ts-ignore
export const reConfirmPass: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const password = control.get("password");
  const confirmPassword = control.get("confirmPassword");

  if (password && confirmPassword && password.touched && password.value != confirmPassword.value) {
    return {"reConfirmPass": true};
  } else {
    return null;
  }

}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  formCreate: FormGroup;


  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.formCreate = this._formBuilder.group({
      email: ['abc@gmail.com', [
        Validators.required,
        Validators.pattern("\\w+[@]\\w+[.]\\w+")
      ]
      ],
      password: ["", [
        Validators.required,
        Validators.minLength(6)
      ]
      ],
      confirmPassword: [],
      country: [],
      country_option: this._formBuilder.array([]),
      age: [18, [
        Validators.min(18)
      ]],
      gender: [],
      phone: ["", [
        Validators.required,
        Validators.pattern("[+84]\\d{9,10}")
      ]
      ]
    }, {validators: reConfirmPass})
  }

  onSubmit() {
    if (this.formCreate.valid) {
      console.log(this.formCreate.value)
    }
  }

  get country_option() {
    return this.formCreate.controls['country_option'] as FormArray;
  }

  addCountry() {
    this.country_option.push(this._formBuilder.control(''))
  }
}
