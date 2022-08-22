import { Company } from './company';

export interface PostInterface {
  id?: number;
  company:Company;
	title:string;
	jobDescription:string;
	preconditions:string[];
	position:string;
	picture:string;
	numOfLikes:number;
	numOfDislikes:number;

}
export class Post implements PostInterface {
  id?: number;
  company:Company;
	title:string;
	jobDescription:string;
	preconditions:string[];
	position:string;
	picture:string;
	numOfLikes:number;
	numOfDislikes:number;

  constructor(obj: PostInterface) {
      this.id = obj.id;
      this.company = obj.company;
      this.title=obj.title;
      this.jobDescription = obj.jobDescription;
      this.preconditions = obj.preconditions;
      this.position=obj.position;
      this.picture = obj.picture;
      this.numOfLikes = obj.numOfLikes;
      this.numOfDislikes=obj.numOfDislikes;

  }

}
