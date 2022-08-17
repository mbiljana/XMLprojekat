import { NumberValueAccessor } from '@angular/forms';
import { UserPost } from './userPost';

export interface UserLikePostDTOInterface {
  userPost:UserPost;
  userId:number;

}
export class UserLikePostDTO implements UserLikePostDTOInterface {
  userPost:UserPost;
  userId:number;

  constructor(obj:UserLikePostDTOInterface) {
    this.userPost = obj.userPost;
    this.userId = obj.userId;
  }
}
