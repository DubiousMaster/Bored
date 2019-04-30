using Core.core.http;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Core.core.userinterface
{
    public partial class DisplayData : Form
    {
        public DisplayData()
        {
            InitializeComponent();
            new ServerCommunicator().Connect();
        }
    }
}
