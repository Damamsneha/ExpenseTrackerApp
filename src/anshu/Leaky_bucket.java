package anshu;

public class Leaky_bucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int no_of_queries=4;
int storage=0;
int input_pkt_size=4;
int output_pkt_size=1;
int bucket_size=10;
int size_left;
for(int i=0;i<no_of_queries;i++){
	size_left=bucket_size-storage;
	if(input_pkt_size<=(size_left)) {
		storage+=input_pkt_size;
	}else {
		System.out.println("Packet loss="+input_pkt_size);
	}
	System.out.println("buffer size="+storage+ "out of bucket="+bucket_size);
	storage-=output_pkt_size;
}
	}

}
