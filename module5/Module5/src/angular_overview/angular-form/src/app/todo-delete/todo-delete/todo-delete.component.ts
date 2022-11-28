import {Component, OnInit} from '@angular/core';
import {TodoService} from "../../service/todo.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Todo} from "../../todo";

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit {
  id: number;
  todo: Todo;
  formGroup: FormGroup;

  constructor(private todoService: TodoService,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private router: Router) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.todoService.findById(this.id).subscribe(
        data => {
          console.log(data)
          this.todo = data[0];
          this.formGroup = this.formBuilder.group({
            id: [this.todo.id],
            content: [this.todo.content]
          });
        });
    });
  }

  deleteTodo(id: number) {
    this.todoService.delete(id).subscribe(data=>{
      this.router.navigate(['/todo/list']);
    });
  }

}
