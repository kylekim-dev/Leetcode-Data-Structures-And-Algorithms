using System;

namespace ConsoleApp7
{
    class Program
    {
        static void Main(string[] args)
        {
        	// 입력된 문자열을 공백기준으로 잘라서 배열에 저장한다.
            string[] s = Console.ReadLine().Split();
            
            // 첫번째 숫자 s[0]과 두번째 숫자 s[1]을 int로 변환하여 더하고 출력한다.
            Console.WriteLine(int.Parse(s[0]) + int.Parse(s[1]));
        }
    }
}