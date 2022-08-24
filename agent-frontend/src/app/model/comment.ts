import { Company } from './company';
import { User } from './user';

export interface CommentInterface {
  id?: number;
  text: string;
  company:Company;
  user:User;
}
export class Comment implements CommentInterface {
  id?: number;
  text: string;
  company:Company;
  user:User;

  constructor(obj: CommentInterface) {
      this.id = obj.id;
      this.text = obj.text;
      this.company = obj.company;
      this.user=obj.user;
  }

}
