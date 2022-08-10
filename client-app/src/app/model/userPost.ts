import { User } from 'src/app/model/user';

export interface UserPostInterface {
  id?:string;
  user:User;
  text: string;
  links:string[];
  picture: string;
}
export class UserPost implements UserPostInterface {
  id?:string;
  user:User;
  text: string;
  links:string[];
  picture: string;

  constructor(obj: UserPostInterface) {
      this.id = obj.id;
      this.user = obj.user;
      this.text=obj.text;
      this.links=obj.links;
      this.picture=obj.picture;
  }
}
