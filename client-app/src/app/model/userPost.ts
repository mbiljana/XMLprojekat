import { User } from 'src/app/model/user';

export interface UserPostInterface {
  id:number;
  user:User;
  text: string;
  links:string[];
  picture: string;
  likes:number;
  dislikes:number;
}
export class UserPost implements UserPostInterface {
  id:number;
  user:User;
  text: string;
  links:string[];
  picture: string;
  likes:number;
  dislikes:number;

  constructor(obj: UserPostInterface) {
      this.id = obj.id;
      this.user = obj.user;
      this.text=obj.text;
      this.links=obj.links;
      this.picture=obj.picture;
      this.likes=obj.likes;
      this.dislikes=obj.dislikes;
  }
}
