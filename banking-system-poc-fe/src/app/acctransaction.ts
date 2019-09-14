export class Acctransaction {
    createdAt:string;
    sender:any;
    receiver:any;
    amountTransferred:number;
    senderOldBalance:number;
    senderNewBalance:number;
    receiverOldBalance:number;
    receiverNewBalance:number;
    checked:boolean;
    failed:boolean;
    id:number;
}
