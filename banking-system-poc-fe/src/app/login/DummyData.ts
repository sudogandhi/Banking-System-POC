import { CustomerLogin } from './CustomerLogin';

export var CustomerData:CustomerLogin[]=
[
    {username:'pvd31',password:'pradnya@31'},
    {username:'chana1',password:'chana123'},
]

localStorage.setItem("UserCredentials",JSON.stringify(CustomerData));