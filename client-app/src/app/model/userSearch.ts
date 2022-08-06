
export interface UserSearchInterface {
  firstName: string;
  lastName: string;
}
export class UserSearch implements UserSearchInterface {
  firstName: string;
  lastName: string;

  constructor(obj: UserSearchInterface) {
      this.firstName = obj.firstName;
      this.lastName = obj.lastName;
  }
}
