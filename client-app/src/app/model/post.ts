import { User } from './user';
import { Company } from './company';

export interface PostInterface {
  id?:number;
  title: string;
  text: string;
  picture: string;
  links: string[];
  numOfLikes: number;
  numOfDislikes: number;
  company: Company;
  followersCanSee:User[];

}
export class Post implements PostInterface {
  id?:number;
  title: string;
  text: string;
  picture: string;
  links: string[];
  numOfLikes: number;
  numOfDislikes: number;
  company: Company;
  followersCanSee:User[];

  constructor(obj: PostInterface) {
      this.id=obj.id;
      this.title=obj.title;
      this.text = obj.text
      this.picture = obj.picture;
      this.links = obj.links;
      this.numOfLikes = obj.numOfLikes;
      this.numOfDislikes=obj.numOfDislikes;
      this.company=obj.company;
      this.followersCanSee=obj.followersCanSee;
  }
}
