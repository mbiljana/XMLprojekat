export interface UsersFollowRequestsInterface {
  username:string;

}
export class UsersFollowRequestsDTO implements UsersFollowRequestsInterface {
  username:string;

  constructor(obj: UsersFollowRequestsInterface) {
    this.username = obj.username;
  }
}
