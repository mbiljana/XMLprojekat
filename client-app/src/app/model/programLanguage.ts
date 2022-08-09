import { User } from './user';
import { Company } from './company';

export interface ProgramLanguageInterface {
  id?:number;
  name: string;
}
export class ProgramLanguage implements ProgramLanguageInterface {
  id?:number;
  name: string;

  constructor(obj: ProgramLanguageInterface) {
      this.id=obj.id;
      this.name=obj.name;
  }
}
