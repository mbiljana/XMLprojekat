import { UserPost } from './userPost';
import { Post } from "./post";
import { User } from './user';


export interface CommentInterface {
  id?:number;
  text: string;
  post:Post;
  userPost:UserPost;
  user:User;
}
export class Comment implements CommentInterface {
  id?:number;
  text: string;
  post:Post;
  userPost:UserPost;
  user:User;

  constructor(obj: CommentInterface) {
      this.id=obj.id;
      this.text=obj.text;
      this.post=obj.post;
      this.userPost=obj.userPost;
      this.user=obj.user;
  }
}
