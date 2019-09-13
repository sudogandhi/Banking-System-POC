/*class Sender
{
  senderOldBalance: string;
  senderNewBalance: string;
}
 class ReceiverAccount
{
  accountNo: number;
}*/
export class Transaction {
  createdAt: string;
  id: string;
  receiver: string;
  senderOldBalance: number;
  senderNewBalance: number;
}
