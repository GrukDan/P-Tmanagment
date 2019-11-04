export class User {
  name: string;
  surname: string;
  email: string;
  role: string;
  login: string;
  password: string;

  static cloneBase(user: User): User {
    const clonedUser: User = new User();
    clonedUser.name = user.name;
    clonedUser.surname = user.surname;
    clonedUser.email = user.email;
    clonedUser.email = user.email;
    clonedUser.role = user.role;
    clonedUser.login = user.login;
    clonedUser.password = user.password;
    return clonedUser;
  }
}
