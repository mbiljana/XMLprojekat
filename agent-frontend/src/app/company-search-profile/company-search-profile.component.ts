import { GradeCompany } from './../model/gradeCompany';
import { CompanyService } from 'src/service/company.service';
import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/service/post.service';
import { Address } from '../model/address';
import { Company } from '../model/company';
import { Post } from '../model/post';
import { User } from '../model/user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-company-search-profile',
  templateUrl: './company-search-profile.component.html',
  styleUrls: ['./company-search-profile.component.css']
})
export class CompanySearchProfileComponent implements OnInit {
  company:Company;
  companyId:number;
  posts:Post[];
  salary:number;
  grade:number;
  choices = [1,2,3,4,5];
  showGradeForm:boolean=false;
  showSalaryForm:boolean=false;
  gradeCompany:GradeCompany;
  averageGrade=0;
  averageSalary=0;
  constructor(private postService:PostService, private companyService:CompanyService,private route: ActivatedRoute) {
    this.gradeCompany=new GradeCompany({
      id:0,
      grade:0,
      company:new Company({
        salaries:[],
        id:0,
        name:'',
        description:'',
        address:new Address({
          city:'',
          state:'',
          street:''
        }),
        username:'',
        email:'',
        mobile:'',
        profilePicture:'',
        grades:[],
        owner:new User({
          id:0,
          firstName: '',
          lastName: '',
          username: '',
          password: '',
          email: '',
          mobile: '',
          gender:'',
          role:'',
          firstLogin:false
        })
      })
    })
    this.company=new Company({
      id:0,
      name:'',
      description:'',
      address:new Address({
        city:'',
        state:'',
        street:''
      }),
      username:'',
      email:'',
      mobile:'',
      profilePicture:'',
      grades:[],
      salaries:[],
      owner:new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        role:'',
        firstLogin:false
      })
    })
  }

  ngOnInit(): void {
    this.loadCompany();
  }
  loadCompany(){
    this.companyId = this.route.snapshot.params['id'];
    this.companyService.getOneById(this.companyId)
    .subscribe(res=>{this.company=res;
      const arr = res.grades;
      const arr1=res.salaries;
      this.averageGrade = arr.reduce((a, b) => a + b, 0) / arr.length;
      this.averageSalary = arr1.reduce((a, b) => a + b, 0) / arr1.length;
      this.postService.getAllByCompanyId(res.id)
      .subscribe(res1=>this.posts=res1)
    })
  }
  rateCompany(){
    this.showGradeForm=true;
  }
  AddGrade(){
    this.gradeCompany.company=this.company;
    this.gradeCompany.grade=this.grade;
    this.companyService.grade(this.gradeCompany)
    .subscribe(res=>{
      const arr = res.grades;
      this.averageGrade = arr.reduce((a, b) => a + b, 0) / arr.length;
    })
    this.showGradeForm=false;
  }
  addSalary(){
    this.showSalaryForm=true;

  }
  AddSalaryFromForm(){
    this.gradeCompany.company=this.company;
    this.gradeCompany.grade=this.salary;
    this.companyService.salary(this.gradeCompany)
    .subscribe(res=>{
      const arr = res.salaries;
      this.averageSalary = arr.reduce((a, b) => a + b, 0) / arr.length;
    })
    this.showSalaryForm=false;
  }
}
