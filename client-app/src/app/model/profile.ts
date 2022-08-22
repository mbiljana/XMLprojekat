import { Language } from './language';
import { ProgramLanguage } from './programLanguage';
import { User } from './user';
import { ProfileType } from './profileType';
export interface ProfileInterface {
    id?: number ;
    user:User;
    proramLanguages:ProgramLanguage[];
    exCompanies:string[];
    languages:Language[];
    supportLanguageList?:string[];
    supportProgramLanguageList?:string[];
    education:string;
    additionInformation:string;
    profileType:ProfileType;
}
export class Profile implements ProfileInterface {
  id?: number ;
  user:User;
  proramLanguages:ProgramLanguage[];
  exCompanies:string[];
  languages:Language[];
  supportLanguageList?:string[];
  supportProgramLanguageList?:string[];
  education:string;
  additionInformation:string;
  profileType:ProfileType;

  constructor(obj: ProfileInterface) {
      this.id = obj.id;
      this.user = obj.user;
      this.proramLanguages = obj.proramLanguages;
      this.exCompanies = obj.exCompanies
      this.languages = obj.languages;
      this.supportLanguageList=obj.supportLanguageList;
      this.supportProgramLanguageList=obj.supportProgramLanguageList;
      this.education = obj.education;
      this.additionInformation = obj.additionInformation;
      this.profileType=obj.profileType;
  }
}
