namespace Core.core.userinterface
{
    partial class DisplayData
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnShowActivity = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lbActivities = new System.Windows.Forms.ListBox();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnShowActivity
            // 
            this.btnShowActivity.Location = new System.Drawing.Point(696, 393);
            this.btnShowActivity.Name = "btnShowActivity";
            this.btnShowActivity.Size = new System.Drawing.Size(92, 29);
            this.btnShowActivity.TabIndex = 0;
            this.btnShowActivity.Text = "Show";
            this.btnShowActivity.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.lbActivities);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(465, 416);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Activities";
            // 
            // lbActivities
            // 
            this.lbActivities.FormattingEnabled = true;
            this.lbActivities.ItemHeight = 16;
            this.lbActivities.Location = new System.Drawing.Point(6, 21);
            this.lbActivities.Name = "lbActivities";
            this.lbActivities.Size = new System.Drawing.Size(448, 388);
            this.lbActivities.TabIndex = 0;
            // 
            // DisplayData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 434);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnShowActivity);
            this.Name = "DisplayData";
            this.Text = "I\'m so bored!";
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnShowActivity;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ListBox lbActivities;
    }
}