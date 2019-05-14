using System;
using System.Windows.Forms;

namespace Bored_V2
{
    public class Program
    {
        [STAThread]
        public static void Main(string[] args)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new userinterface.MainMenu());
        }
    }
}
