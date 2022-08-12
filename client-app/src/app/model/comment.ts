import { UserPost } from './userPost';
import { Post } from "./post";


export interface CommentInterface {
  id?:number;
  text: string;
  post:Post;
  userPost:UserPost;
}
export class Comment implements CommentInterface {
  id?:number;
  text: string;
  post:Post;
  userPost:UserPost;

  constructor(obj: CommentInterface) {
      this.id=obj.id;
      this.text=obj.text;
      this.post=obj.post;
      this.userPost=obj.userPost;
  }
}
