package FileNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class NIOReadWriteChannel {
	
	private static final String name = "byFileChannel.txt";

	public static void main(String[] args) throws IOException {
		String string = "foo bar foobar";
		byte[] bytes = string.getBytes();
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		fileChannelWrite(byteBuffer);
		
		System.out.println("-----READING-------");
		fileChannelRead();

	}
	
	public static void fileChannelRead() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("./"+name,
				"rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		Charset charset = Charset.forName("US-ASCII");
		while (fileChannel.read(byteBuffer) > 0) {
			byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			byteBuffer.flip();
		}
		fileChannel.close();
		randomAccessFile.close();
	}
	
	public static void fileChannelWrite(ByteBuffer byteBuffer)
			throws IOException {

		Set options = new HashSet();
		options.add(StandardOpenOption.CREATE);
		options.add(StandardOpenOption.APPEND);

		Path path = Paths.get("./byFileChannel.txt");

		FileChannel fileChannel = FileChannel.open(path, options);
		fileChannel.write(byteBuffer);
		fileChannel.close();
	}


}
