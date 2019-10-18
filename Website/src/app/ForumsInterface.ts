export interface forums {
    data?: (User)[] | null;
  }
  export interface User {
    forumsid: number | null;
    forumstopic: string | null;
    forumscomment?: string | null;
    userid: number | null;
    userlastname?: string | null;
    userfirstname?: string | null;
    useremail: string | null;
    userpassword?: string | null;
    userstreetaddress?: null;
    usercity?: null;
    userstate?: null;
  }
  