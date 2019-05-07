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
            this.lblNameFilter = new System.Windows.Forms.Label();
            this.tbNameFilter = new System.Windows.Forms.TextBox();
            this.gboxAccessibility = new System.Windows.Forms.GroupBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.nudBound2 = new System.Windows.Forms.NumericUpDown();
            this.nudBound1 = new System.Windows.Forms.NumericUpDown();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown2 = new System.Windows.Forms.NumericUpDown();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.numericUpDown3 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown4 = new System.Windows.Forms.NumericUpDown();
            this.btnAdvancedSearch = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.gboxAccessibility.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudBound2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudBound1)).BeginInit();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).BeginInit();
            this.SuspendLayout();
            // 
            // btnShowActivity
            // 
            this.btnShowActivity.Location = new System.Drawing.Point(696, 379);
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
            this.lbActivities.Size = new System.Drawing.Size(448, 372);
            this.lbActivities.TabIndex = 0;
            // 
            // lblNameFilter
            // 
            this.lblNameFilter.AutoSize = true;
            this.lblNameFilter.Location = new System.Drawing.Point(483, 36);
            this.lblNameFilter.Name = "lblNameFilter";
            this.lblNameFilter.Size = new System.Drawing.Size(106, 17);
            this.lblNameFilter.TabIndex = 2;
            this.lblNameFilter.Text = "Name contains:";
            // 
            // tbNameFilter
            // 
            this.tbNameFilter.Location = new System.Drawing.Point(595, 33);
            this.tbNameFilter.Name = "tbNameFilter";
            this.tbNameFilter.Size = new System.Drawing.Size(193, 22);
            this.tbNameFilter.TabIndex = 3;
            // 
            // gboxAccessibility
            // 
            this.gboxAccessibility.Controls.Add(this.label2);
            this.gboxAccessibility.Controls.Add(this.label1);
            this.gboxAccessibility.Controls.Add(this.nudBound2);
            this.gboxAccessibility.Controls.Add(this.nudBound1);
            this.gboxAccessibility.Location = new System.Drawing.Point(486, 61);
            this.gboxAccessibility.Name = "gboxAccessibility";
            this.gboxAccessibility.Size = new System.Drawing.Size(302, 100);
            this.gboxAccessibility.TabIndex = 4;
            this.gboxAccessibility.TabStop = false;
            this.gboxAccessibility.Text = "Accessibility";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 61);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Upperbound:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(90, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Lowerbound:";
            // 
            // nudBound2
            // 
            this.nudBound2.Location = new System.Drawing.Point(109, 59);
            this.nudBound2.Name = "nudBound2";
            this.nudBound2.Size = new System.Drawing.Size(187, 22);
            this.nudBound2.TabIndex = 1;
            this.nudBound2.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // nudBound1
            // 
            this.nudBound1.Location = new System.Drawing.Point(109, 21);
            this.nudBound1.Name = "nudBound1";
            this.nudBound1.Size = new System.Drawing.Size(187, 22);
            this.nudBound1.TabIndex = 0;
            this.nudBound1.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.numericUpDown1);
            this.groupBox2.Controls.Add(this.numericUpDown2);
            this.groupBox2.Location = new System.Drawing.Point(486, 167);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(302, 100);
            this.groupBox2.TabIndex = 5;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Participants";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 61);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(91, 17);
            this.label3.TabIndex = 3;
            this.label3.Text = "Upperbound:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 26);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(90, 17);
            this.label4.TabIndex = 2;
            this.label4.Text = "Lowerbound:";
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Location = new System.Drawing.Point(109, 59);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(187, 22);
            this.numericUpDown1.TabIndex = 1;
            this.numericUpDown1.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // numericUpDown2
            // 
            this.numericUpDown2.Location = new System.Drawing.Point(109, 21);
            this.numericUpDown2.Name = "numericUpDown2";
            this.numericUpDown2.Size = new System.Drawing.Size(187, 22);
            this.numericUpDown2.TabIndex = 0;
            this.numericUpDown2.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label5);
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.numericUpDown3);
            this.groupBox3.Controls.Add(this.numericUpDown4);
            this.groupBox3.Location = new System.Drawing.Point(486, 273);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(302, 100);
            this.groupBox3.TabIndex = 5;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Price";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 61);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(91, 17);
            this.label5.TabIndex = 3;
            this.label5.Text = "Upperbound:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(6, 26);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(90, 17);
            this.label6.TabIndex = 2;
            this.label6.Text = "Lowerbound:";
            // 
            // numericUpDown3
            // 
            this.numericUpDown3.Location = new System.Drawing.Point(109, 59);
            this.numericUpDown3.Name = "numericUpDown3";
            this.numericUpDown3.Size = new System.Drawing.Size(187, 22);
            this.numericUpDown3.TabIndex = 1;
            this.numericUpDown3.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // numericUpDown4
            // 
            this.numericUpDown4.Location = new System.Drawing.Point(109, 21);
            this.numericUpDown4.Name = "numericUpDown4";
            this.numericUpDown4.Size = new System.Drawing.Size(187, 22);
            this.numericUpDown4.TabIndex = 0;
            this.numericUpDown4.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // btnAdvancedSearch
            // 
            this.btnAdvancedSearch.Location = new System.Drawing.Point(486, 379);
            this.btnAdvancedSearch.Name = "btnAdvancedSearch";
            this.btnAdvancedSearch.Size = new System.Drawing.Size(204, 29);
            this.btnAdvancedSearch.TabIndex = 6;
            this.btnAdvancedSearch.Text = "Advanced search";
            this.btnAdvancedSearch.UseVisualStyleBackColor = true;
            this.btnAdvancedSearch.Click += new System.EventHandler(this.BtnAdvancedSearch_Click);
            // 
            // DisplayData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 417);
            this.Controls.Add(this.btnAdvancedSearch);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.gboxAccessibility);
            this.Controls.Add(this.tbNameFilter);
            this.Controls.Add(this.lblNameFilter);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnShowActivity);
            this.Name = "DisplayData";
            this.Text = "I\'m so bored!";
            this.groupBox1.ResumeLayout(false);
            this.gboxAccessibility.ResumeLayout(false);
            this.gboxAccessibility.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudBound2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudBound1)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnShowActivity;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ListBox lbActivities;
        private System.Windows.Forms.Label lblNameFilter;
        private System.Windows.Forms.TextBox tbNameFilter;
        private System.Windows.Forms.GroupBox gboxAccessibility;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.NumericUpDown nudBound2;
        private System.Windows.Forms.NumericUpDown nudBound1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown numericUpDown1;
        private System.Windows.Forms.NumericUpDown numericUpDown2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.NumericUpDown numericUpDown3;
        private System.Windows.Forms.NumericUpDown numericUpDown4;
        private System.Windows.Forms.Button btnAdvancedSearch;
    }
}