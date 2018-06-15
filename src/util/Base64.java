package util;

import java.io.ByteArrayOutputStream;

public class Base64
{
	/**
	 * Base64编码要求把每三个8Bit的字节转换为四个6Bit的字节（3*8 = 4*6 = 24），然后把6Bit再添两位高位0，组成四个8Bit的字节。
	 * <p>关于这个编码的规则：</p>
	 * <li>①、把3个字符变成4个字符</li>
	 * <li>②、每76个字符加一个换行符</li>
	 * <li>③、最后的结束符也要处理。</li>
	 * <p>例子：</p>
	 * <br>转换前 aaaaaabb ccccdddd eeffffff
	 * <br>转换后 00aaaaaa 00bbcccc 00ddddee 00ffffff<br>
	 * 上面的三个字节是原文，下面的四个字节是转换后的Base64编码，其前两位均为0。
	 * @param s 待编码的字符串
	 * @param base64 Base64参照表
	 * @return
	 */
	public static String encode64(String s, String base64)
	{
		ByteArrayOutputStream o = new ByteArrayOutputStream();

		byte[] sb = s.getBytes();

		int val = 0;
		int n = 0;
		for (int i = 0; i < sb.length; i+=3)
		{
			//利用int类型4个字节暂存数据
			val = (sb[i] << 16) 
				| (i + 1 < sb.length ? (0xFF & sb[i + 1]) << 8 : 0) 
				| (i + 2 < sb.length ? (0xFF & sb[i + 2]) : 0);
			
			//每3个字符转换成4个字符
			o.write(base64.charAt((val >> 18) & 0x3F));
			o.write(base64.charAt((val >> 12) & 0x3F));
			o.write(((val >> 6) & 0x3F) != 0 ? base64.charAt((val >> 6) & 0x3F) : '=');
			o.write((val & 0x3F) != 0 ? base64.charAt(val & 0x3F) : '=');
			
			n+=4;
			if(n == 76)//加回车换行符
			{
				n = 0;
				o.write(13);
				o.write(10);
			}
		}

		return o.toString();
	}
	
	/**
	 * Base64解码要求把8Bit的字节去掉两位高位0形成6Bit字节，再把每四个6Bit的字节转换为三个8Bit的字节（4*6 = 3*8 = 24）。
	 * <p>关于这个解码的规则：</p>
	 * <li>①、把4个字符变成3个字符</li>
	 * <li>③、去掉最后的结束符。</li>
	 * <p>例子：</p>
	 * <br>转换前 00aaaaaa 00bbcccc 00ddddee 00ffffff
	 * <br>转换后 aaaaaabb ccccdddd eeffffff<br>
	 * 上面的四个字节是经Base64编码后的蜜文，下面的三个字节是解码后的原文。
	 * @param s 待解码的字符串
	 * @param base64 Base64参照表
	 * @return
	 */
	public static String decode64(String s, String base64)
	{
		ByteArrayOutputStream o = new ByteArrayOutputStream();

		byte[] sb = s.getBytes();

		int val = 0;
		int n = 0;
		for (int i = 0; i < sb.length; i++)
		{
			if (sb[i] != 10 && sb[i] != 13)//去掉回车换行符
			{
				//利用int类型4个字节暂存数据
				val = (val << 6) | (sb[i] != '=' ? base64.indexOf(sb[i]) : 0);
				n++;
			}
			if (n == 4)//每4个字符转换成3个字符
			{
				o.write((val >> 16) & 0xff);
				if (((val >> 8) & 0xff) != 0) o.write((val >> 8) & 0xff);
				if ((val & 0xff) != 0) o.write(val & 0xff);

				n = 0;
				val = 0;
			}
		}
		return o.toString();
	}
	
	public static String Base64Encode(String s, String base64)
	{
		byte c1, c2, c3;
		int m = 0, n = 0;

		byte[] sb = s.getBytes();

		ByteArrayOutputStream o = new ByteArrayOutputStream();

		try
		{
			for (int i = 0; i < sb.length / 3; i++)
			{
				c1 = sb[m];
				c2 = sb[m + 1];
				c3 = sb[m + 2];
				m += 3;

				o.write(base64.charAt((c1 >> 2) & 0x3F));
				o.write(base64.charAt(((c1 << 4) & 0x30) | ((c2 >> 4) & 0x0F)));
				o.write(base64.charAt(((c2 << 2) & 0x3C) | ((c3 >> 6) & 0x03)));
				o.write(base64.charAt(c3 & 0x3F));

				n += 4;
				if (n == 76)//加回车换行符
				{
					n = 0;
					//o.write(13);
					//o.write(10);
				}
			}
			//剩余一个字符 8Bit
			if (sb.length % 3 == 1)
			{
				c1 = sb[m];

				o.write(base64.charAt((c1 >> 2) & 0x3F));
				o.write(base64.charAt(((c1 << 4) & 0x30)));
				o.write('=');
				o.write('=');
			}
			//剩余两个字符 16Bit
			if (sb.length % 3 == 2)
			{
				c1 = sb[m];
				c2 = sb[m + 1];

				o.write(base64.charAt((c1 >> 2) & 0x3F));
				o.write(base64.charAt(((c1 << 4) & 0x30) | ((c2 >> 4) & 0x0F)));
				o.write(base64.charAt(((c2 << 2) & 0x3C)));
				o.write('=');
			}
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
		}

		return o.toString();
	}

	public static String Base64Decode(String s, String base64)
	{
		int m, n;
		byte c1, c2, c3, c4;

		ByteArrayOutputStream o = new ByteArrayOutputStream();

		if (s == null || "".equals(s)) return "";

		byte[] sb = s.getBytes();

		try
		{
			n = 0;
			m = sb.length;

			// 去掉尾部"=",最多只有2个
			if ('=' == (char) sb[m - 1]) --m;
			if ('=' == (char) sb[m - 1]) --m;

			for (int i = 0; i < m / 4; i++)
			{
				c1 = (byte) base64.indexOf(sb[n]);
				c2 = (byte) base64.indexOf(sb[n + 1]);
				c3 = (byte) base64.indexOf(sb[n + 2]);
				c4 = (byte) base64.indexOf(sb[n + 3]);
				n += 4;

				o.write((char) (((c1 << 2) & 0xFC) | ((c2 >> 4) & 0x03)));
				o.write((char) (((c2 << 4) & 0xF0) | ((c3 >> 2) & 0x0F)));
				o.write((char) (((c3 << 6) & 0xC0) | c4));
			}
			if (m % 4 == 2)
			{
				c1 = (byte) base64.indexOf(sb[n]);
				c2 = (byte) base64.indexOf(sb[n + 1]);

				o.write((char) (((c1 << 2) & 0xFC) | ((c2 >> 4) & 0x03)));
			}
			if (m % 4 == 3)
			{
				c1 = (byte) base64.indexOf(sb[n]);
				c2 = (byte) base64.indexOf(sb[n + 1]);
				c3 = (byte) base64.indexOf(sb[n + 2]);

				o.write((char) (((c1 << 2) & 0xFC) | ((c2 >> 4) & 0x03)));
				o.write((char) (((c2 << 4) & 0xF0) | ((c3 >> 2) & 0x0F)));
			}
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
		}

		return o.toString();
	}
	
	/**
	 * BASE64解码
	 * @param Value 待解码的BASE64编码字符串
	 * @param Table_Base64 BASE64编码参照字符表
	 * @return 返回原始串
	 */
	public static String DecodeBase64(String Value, String Table_Base64)
	{
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		byte[] d = new byte[4];
		try
		{
			int count = 0;
			for (byte[] x = Value.getBytes(); count < x.length;)
			{
				for (int n = 0; n <= 3; n++) //Base64编码后的字符串长度一定能被4整除
				{
					if(count < x.length)
					{
						int y = Table_Base64.indexOf(x[count]); if(y == 64) System.out.println("get");
						if (y < 0) y = 65; // 非可编码字符一律转换为字符'A'
						d[n] = (byte) y;
					}
					else
					{
						d[n] = 64; // '@'
					}

					count++;
				}

				o.write((byte) (((d[0] & 0x3f) << 2) + ((d[1] & 0x30) >> 4)));
				if (d[2] != 64)
				{
					o.write((byte) (((d[1] & 0x0f) << 4) + ((d[2] & 0x3c) >> 2)));
					if (d[3] != 64) o.write((byte) (((d[2] & 0x3) << 6) + (d[3] & 0x3f)));
				}
			}
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
		}
		return o.toString();
	}

	/**
	 * BASE64编码
	 * @param Value 待编码字符串
	 * @param Table_Base64 BASE64编码参照字符表
	 * @return 返回BASE64编码串
	 */
	public static String EncodeBase64(String Value, String Table_Base64)
	{
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		byte[] d = new byte[4];
		try
		{
			int count = 0;
			for (byte x[] = Value.getBytes(); count < x.length;)
			{
				byte c = x[count];
				count++;
				d[0] = (byte) ((c & 0xfc) >> 2);
				d[1] = (byte) ((c & 0x03) << 4);
				if (count < x.length)
				{
					c = x[count];
					count++;
					d[1] = (byte) (d[1] + (byte) ((c & 0xf0) >> 4));
					d[2] = (byte) ((c & 0xf) << 2);
					if (count < x.length)
					{
						c = x[count];
						count++;
						d[2] = (byte) (d[2] + ((c & 0xc0) >> 6));
						d[3] = (byte) (c & 0x3f);
					}
					else
					{
						d[3] = 64;
					}
				}
				else
				{
					d[2] = 64;
					d[3] = 64;
				}
				for (int n = 0; n <= 3; n++)
					o.write(Table_Base64.charAt(d[n]));
			}
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
		}
		return o.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println((char)64);
	}
}
