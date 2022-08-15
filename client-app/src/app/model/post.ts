import { User } from './user';
import { Company } from './company';

export interface PostInterface {
  id:number;
  title: string;
  jobDescription: string;
  picture: string;
  preconditions: string[];
  position:string;
  numOfLikes: number;
  numOfDislikes: number;
  company: Company;
  //followersCanSee:User[];

}
export class Post implements PostInterface {
  id:number;
  title: string;
  jobDescription: string;
  picture: string;
  preconditions: string[];
  position:string;
  numOfLikes: number;
  numOfDislikes: number;
  company: Company;
  //followersCanSee:User[];

  constructor(obj: PostInterface) {
      this.id=obj.id;
      this.title=obj.title;
      this.jobDescription = obj.jobDescription
      this.picture = obj.picture;
      this.position=obj.position;
      this.preconditions = obj.preconditions;
      this.numOfLikes = obj.numOfLikes;
      this.numOfDislikes=obj.numOfDislikes;
      this.company=obj.company;
      //this.followersCanSee=obj.followersCanSee;
  }
}
