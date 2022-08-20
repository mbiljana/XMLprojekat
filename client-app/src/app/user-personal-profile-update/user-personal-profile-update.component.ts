import { Language } from './../model/language';
import { LanguageService } from './../../service/language.service';
import { ProfileType } from './../model/profileType';
import { Profile } from './../model/profile';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from './../../service/profile.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import {UserPost} from "../model/userPost";
import {UserPostService} from "../../service/user-post.service";
import {CommentService} from "../../service/comment.service";
import { ThisReceiver } from '@angular/compiler';
import { ProgramLanguage } from '../model/programLanguage';

@Component({
  selector: 'app-user-personal-profile-update',
  templateUrl: './user-personal-profile-update.component.html',
  styleUrls: ['./user-personal-profile-update.component.css']
})

export class UserPersonalProfileUpdateComponent implements OnInit {

  profile:Profile;
  id:number;
  posts:UserPost[];
  post:UserPost;
  showUserPosts:boolean=true;
  showHolePost:boolean=false;
  programLanguagesLists:string;
  languagesLists:string;
  exCompaniesLists:string;
  newLanguage:Language;
  foundLanguage:Language;

  constructor(private languageService: LanguageService,
    private route: ActivatedRoute,private profileService: ProfileService,private userPostService: UserPostService,private commentService:CommentService) {
    this.posts=[]
    this.profile=new Profile({
      user:new User({
        id:0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender:'',
        profileType:ProfileType.Private,
        role:'',
        firstLogin:false,
        following:[],
        followRequests:[]

      }),
      proramLanguages:[],
      exCompanies:[],
      languages:[],
      education:'',
      additionInformation:'',
      profileType:ProfileType.Private
    });
    this.newLanguage=new Language({
      id:0,
      name:''
    })
  }

  ngOnInit(): void {
    this.loadProfile();
  }
  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.getProfile(this.id)
      .subscribe(res=>{
        this.profile=res;
        this.insertProgramLanguagesIntoString(res.proramLanguages);
        this.insertLanguagesIntoString(res.languages);
        this.insertExCompaniesIntoString(res.exCompanies);
        this.userPostService.searchPostByUser(this.id)
          .subscribe(res=>this.posts=res)
      })
  }
  saveChanges(){
//treba sada stringove pretvoriti u liste
  this.profile.exCompanies=this.exCompaniesLists.split(",");
  //treba ispraviti , provere treba da se desavaju na backendu
  //programske jezike i jezike treba naci iz baze,treba naci da li jezik sa tim imenom postoji ako ne treba kreirati novi
  /*var listLanguageName=this.languagesLists.split(",");
  //this.profile.languages.splice(0)
  for(var val of listLanguageName){
    this.newLanguage.name=val;
    this.languageService.findByName(val)
    .subscribe(res=>{
      if(res!=null){
        this.profile.languages.push(res);
        console.log("postoji")
        console.log(res)
      }
      else{
      this.languageService.save(this.newLanguage)
        .subscribe(res1=>this.profile.languages.push(res1))
      }
    })
  }*/

  this.profile.languages.push(this.newLanguage);
  this.profileService.updateProfile(this.profile)
    .subscribe()

  }
  insertProgramLanguagesIntoString(languages:ProgramLanguage[]){
    var listaImena:string[]=[];
    languages.forEach(function(lan:ProgramLanguage){
      listaImena.push(lan.name)
    })
    this.programLanguagesLists=listaImena.join(",")
  }
  insertLanguagesIntoString(languages:Language[]){
    var listaImena:string[]=[];
    languages.forEach(function(lan:Language){
      listaImena.push(lan.name)
    })
    this.languagesLists=listaImena.join(",")
  }
  insertExCompaniesIntoString(languages:string[]){
    var listaImena:string[]=[];
    languages.forEach(function(lan:string){
      listaImena.push(lan)
    })
    this.exCompaniesLists=listaImena.join(",")
  }

}
