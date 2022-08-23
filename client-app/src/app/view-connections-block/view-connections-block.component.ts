import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../service/profile.service";
import {ConnectionsService} from "../../service/connections.service";
import {User} from "../model/user";
import {UserPostService} from "../../service/user-post.service";
import {CommentService} from "../../service/comment.service";
import {Profile} from "../model/profile";
import {ProfileType} from "../model/profileType";
import {ConnectionsNumberDTO} from "../model/ConnectionsNumberDTO";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-view-connections-block',
  templateUrl: './view-connections-block.component.html',
  styleUrls: ['./view-connections-block.component.css']
})

export class ViewConnectionsBlockComponent implements OnInit {

  id: number;
  loggedUser: User;
  profile: Profile;

  @Input()
  connections: string[];

  constructor(private route: ActivatedRoute, private profileService: ProfileService, private userService: UserService, private commentService: CommentService, private connectionService: ConnectionsService) {
    this.profile = new Profile({
      user: new User({
        id: 0,
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        gender: '',
        profileType: ProfileType.Private,
        role: '',
        firstLogin: false,
        following: [],
        followRequests: []
      }),
      proramLanguages: [],
      exCompanies: [],
      languages: [],
      education: '',
      additionInformation: '',
      profileType: ProfileType.Private
    });
  }
  ngOnInit(): void {

  }


}

