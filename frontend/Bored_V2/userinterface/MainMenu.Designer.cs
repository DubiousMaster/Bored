namespace Bored_V2.userinterface
{
    partial class MainMenu
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
            this.tboxName = new System.Windows.Forms.TextBox();
            this.gboxAccessibility = new System.Windows.Forms.GroupBox();
            this.lblUpperboundaryAccessibility = new System.Windows.Forms.Label();
            this.lblLowerboundaryAccessibility = new System.Windows.Forms.Label();
            this.nudUpperboundAccessibility = new System.Windows.Forms.NumericUpDown();
            this.nudLowerboundAccessibility = new System.Windows.Forms.NumericUpDown();
            this.btnConfirmAccessibility = new System.Windows.Forms.Button();
            this.gboxParticipants = new System.Windows.Forms.GroupBox();
            this.lblUpperboundaryParticipants = new System.Windows.Forms.Label();
            this.nudUpperboundParticipants = new System.Windows.Forms.NumericUpDown();
            this.lblLowerboundaryParticipants = new System.Windows.Forms.Label();
            this.nudLowerboundParticipants = new System.Windows.Forms.NumericUpDown();
            this.btnConfirmParticipants = new System.Windows.Forms.Button();
            this.gboxPrice = new System.Windows.Forms.GroupBox();
            this.lblUpperboundaryPrice = new System.Windows.Forms.Label();
            this.nudUpperboundPrice = new System.Windows.Forms.NumericUpDown();
            this.lblLowerboundaryPrice = new System.Windows.Forms.Label();
            this.nudLowerboundPrice = new System.Windows.Forms.NumericUpDown();
            this.btnConfirmPrice = new System.Windows.Forms.Button();
            this.btnAdvancedSearch = new System.Windows.Forms.Button();
            this.lboxActivities = new System.Windows.Forms.ListBox();
            this.lblNameContains = new System.Windows.Forms.Label();
            this.lblActivities = new System.Windows.Forms.Label();
            this.gboxAccessibility.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundAccessibility)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundAccessibility)).BeginInit();
            this.gboxParticipants.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundParticipants)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundParticipants)).BeginInit();
            this.gboxPrice.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundPrice)).BeginInit();
            this.SuspendLayout();
            // 
            // tboxName
            // 
            this.tboxName.Location = new System.Drawing.Point(622, 23);
            this.tboxName.Name = "tboxName";
            this.tboxName.Size = new System.Drawing.Size(195, 22);
            this.tboxName.TabIndex = 1;
            // 
            // gboxAccessibility
            // 
            this.gboxAccessibility.Controls.Add(this.lblUpperboundaryAccessibility);
            this.gboxAccessibility.Controls.Add(this.lblLowerboundaryAccessibility);
            this.gboxAccessibility.Controls.Add(this.nudUpperboundAccessibility);
            this.gboxAccessibility.Controls.Add(this.nudLowerboundAccessibility);
            this.gboxAccessibility.Controls.Add(this.btnConfirmAccessibility);
            this.gboxAccessibility.Location = new System.Drawing.Point(469, 51);
            this.gboxAccessibility.Name = "gboxAccessibility";
            this.gboxAccessibility.Size = new System.Drawing.Size(361, 122);
            this.gboxAccessibility.TabIndex = 2;
            this.gboxAccessibility.TabStop = false;
            this.gboxAccessibility.Text = "Accessibility";
            // 
            // lblUpperboundaryAccessibility
            // 
            this.lblUpperboundaryAccessibility.AutoSize = true;
            this.lblUpperboundaryAccessibility.Location = new System.Drawing.Point(15, 51);
            this.lblUpperboundaryAccessibility.Name = "lblUpperboundaryAccessibility";
            this.lblUpperboundaryAccessibility.Size = new System.Drawing.Size(115, 17);
            this.lblUpperboundaryAccessibility.TabIndex = 3;
            this.lblUpperboundaryAccessibility.Text = "Upper boundary:";
            // 
            // lblLowerboundaryAccessibility
            // 
            this.lblLowerboundaryAccessibility.AutoSize = true;
            this.lblLowerboundaryAccessibility.Location = new System.Drawing.Point(15, 23);
            this.lblLowerboundaryAccessibility.Name = "lblLowerboundaryAccessibility";
            this.lblLowerboundaryAccessibility.Size = new System.Drawing.Size(114, 17);
            this.lblLowerboundaryAccessibility.TabIndex = 2;
            this.lblLowerboundaryAccessibility.Text = "Lower boundary:";
            // 
            // nudUpperboundAccessibility
            // 
            this.nudUpperboundAccessibility.DecimalPlaces = 2;
            this.nudUpperboundAccessibility.Location = new System.Drawing.Point(153, 49);
            this.nudUpperboundAccessibility.Name = "nudUpperboundAccessibility";
            this.nudUpperboundAccessibility.Size = new System.Drawing.Size(195, 22);
            this.nudUpperboundAccessibility.TabIndex = 1;
            this.nudUpperboundAccessibility.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // nudLowerboundAccessibility
            // 
            this.nudLowerboundAccessibility.DecimalPlaces = 2;
            this.nudLowerboundAccessibility.Location = new System.Drawing.Point(153, 21);
            this.nudLowerboundAccessibility.Name = "nudLowerboundAccessibility";
            this.nudLowerboundAccessibility.Size = new System.Drawing.Size(195, 22);
            this.nudLowerboundAccessibility.TabIndex = 0;
            this.nudLowerboundAccessibility.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // btnConfirmAccessibility
            // 
            this.btnConfirmAccessibility.Location = new System.Drawing.Point(153, 77);
            this.btnConfirmAccessibility.Name = "btnConfirmAccessibility";
            this.btnConfirmAccessibility.Size = new System.Drawing.Size(195, 39);
            this.btnConfirmAccessibility.TabIndex = 5;
            this.btnConfirmAccessibility.Text = "Show";
            this.btnConfirmAccessibility.UseVisualStyleBackColor = true;
            this.btnConfirmAccessibility.Click += new System.EventHandler(this.BtnConfirmAccessibility_Click);
            // 
            // gboxParticipants
            // 
            this.gboxParticipants.Controls.Add(this.lblUpperboundaryParticipants);
            this.gboxParticipants.Controls.Add(this.nudUpperboundParticipants);
            this.gboxParticipants.Controls.Add(this.lblLowerboundaryParticipants);
            this.gboxParticipants.Controls.Add(this.nudLowerboundParticipants);
            this.gboxParticipants.Controls.Add(this.btnConfirmParticipants);
            this.gboxParticipants.Location = new System.Drawing.Point(469, 179);
            this.gboxParticipants.Name = "gboxParticipants";
            this.gboxParticipants.Size = new System.Drawing.Size(361, 133);
            this.gboxParticipants.TabIndex = 3;
            this.gboxParticipants.TabStop = false;
            this.gboxParticipants.Text = "Participants";
            // 
            // lblUpperboundaryParticipants
            // 
            this.lblUpperboundaryParticipants.AutoSize = true;
            this.lblUpperboundaryParticipants.Location = new System.Drawing.Point(15, 51);
            this.lblUpperboundaryParticipants.Name = "lblUpperboundaryParticipants";
            this.lblUpperboundaryParticipants.Size = new System.Drawing.Size(115, 17);
            this.lblUpperboundaryParticipants.TabIndex = 5;
            this.lblUpperboundaryParticipants.Text = "Upper boundary:";
            // 
            // nudUpperboundParticipants
            // 
            this.nudUpperboundParticipants.Location = new System.Drawing.Point(153, 49);
            this.nudUpperboundParticipants.Name = "nudUpperboundParticipants";
            this.nudUpperboundParticipants.Size = new System.Drawing.Size(195, 22);
            this.nudUpperboundParticipants.TabIndex = 3;
            this.nudUpperboundParticipants.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // lblLowerboundaryParticipants
            // 
            this.lblLowerboundaryParticipants.AutoSize = true;
            this.lblLowerboundaryParticipants.Location = new System.Drawing.Point(15, 23);
            this.lblLowerboundaryParticipants.Name = "lblLowerboundaryParticipants";
            this.lblLowerboundaryParticipants.Size = new System.Drawing.Size(114, 17);
            this.lblLowerboundaryParticipants.TabIndex = 4;
            this.lblLowerboundaryParticipants.Text = "Lower boundary:";
            // 
            // nudLowerboundParticipants
            // 
            this.nudLowerboundParticipants.Location = new System.Drawing.Point(153, 21);
            this.nudLowerboundParticipants.Name = "nudLowerboundParticipants";
            this.nudLowerboundParticipants.Size = new System.Drawing.Size(195, 22);
            this.nudLowerboundParticipants.TabIndex = 2;
            this.nudLowerboundParticipants.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // btnConfirmParticipants
            // 
            this.btnConfirmParticipants.Location = new System.Drawing.Point(153, 77);
            this.btnConfirmParticipants.Name = "btnConfirmParticipants";
            this.btnConfirmParticipants.Size = new System.Drawing.Size(195, 39);
            this.btnConfirmParticipants.TabIndex = 5;
            this.btnConfirmParticipants.Text = "Show";
            this.btnConfirmParticipants.UseVisualStyleBackColor = true;
            this.btnConfirmParticipants.Click += new System.EventHandler(this.BtnConfirmParticipants_Click);
            // 
            // gboxPrice
            // 
            this.gboxPrice.Controls.Add(this.lblUpperboundaryPrice);
            this.gboxPrice.Controls.Add(this.nudUpperboundPrice);
            this.gboxPrice.Controls.Add(this.lblLowerboundaryPrice);
            this.gboxPrice.Controls.Add(this.nudLowerboundPrice);
            this.gboxPrice.Controls.Add(this.btnConfirmPrice);
            this.gboxPrice.Location = new System.Drawing.Point(469, 318);
            this.gboxPrice.Name = "gboxPrice";
            this.gboxPrice.Size = new System.Drawing.Size(361, 121);
            this.gboxPrice.TabIndex = 4;
            this.gboxPrice.TabStop = false;
            this.gboxPrice.Text = "Price";
            // 
            // lblUpperboundaryPrice
            // 
            this.lblUpperboundaryPrice.AutoSize = true;
            this.lblUpperboundaryPrice.Location = new System.Drawing.Point(15, 51);
            this.lblUpperboundaryPrice.Name = "lblUpperboundaryPrice";
            this.lblUpperboundaryPrice.Size = new System.Drawing.Size(115, 17);
            this.lblUpperboundaryPrice.TabIndex = 7;
            this.lblUpperboundaryPrice.Text = "Upper boundary:";
            // 
            // nudUpperboundPrice
            // 
            this.nudUpperboundPrice.DecimalPlaces = 2;
            this.nudUpperboundPrice.Location = new System.Drawing.Point(153, 49);
            this.nudUpperboundPrice.Name = "nudUpperboundPrice";
            this.nudUpperboundPrice.Size = new System.Drawing.Size(195, 22);
            this.nudUpperboundPrice.TabIndex = 5;
            this.nudUpperboundPrice.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // lblLowerboundaryPrice
            // 
            this.lblLowerboundaryPrice.AutoSize = true;
            this.lblLowerboundaryPrice.Location = new System.Drawing.Point(15, 23);
            this.lblLowerboundaryPrice.Name = "lblLowerboundaryPrice";
            this.lblLowerboundaryPrice.Size = new System.Drawing.Size(114, 17);
            this.lblLowerboundaryPrice.TabIndex = 6;
            this.lblLowerboundaryPrice.Text = "Lower boundary:";
            // 
            // nudLowerboundPrice
            // 
            this.nudLowerboundPrice.DecimalPlaces = 2;
            this.nudLowerboundPrice.Location = new System.Drawing.Point(153, 21);
            this.nudLowerboundPrice.Name = "nudLowerboundPrice";
            this.nudLowerboundPrice.Size = new System.Drawing.Size(195, 22);
            this.nudLowerboundPrice.TabIndex = 4;
            this.nudLowerboundPrice.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // btnConfirmPrice
            // 
            this.btnConfirmPrice.Location = new System.Drawing.Point(153, 77);
            this.btnConfirmPrice.Name = "btnConfirmPrice";
            this.btnConfirmPrice.Size = new System.Drawing.Size(195, 39);
            this.btnConfirmPrice.TabIndex = 5;
            this.btnConfirmPrice.Text = "Show";
            this.btnConfirmPrice.UseVisualStyleBackColor = true;
            this.btnConfirmPrice.Click += new System.EventHandler(this.BtnConfirmPrice_Click);
            // 
            // btnAdvancedSearch
            // 
            this.btnAdvancedSearch.Location = new System.Drawing.Point(469, 445);
            this.btnAdvancedSearch.Name = "btnAdvancedSearch";
            this.btnAdvancedSearch.Size = new System.Drawing.Size(361, 33);
            this.btnAdvancedSearch.TabIndex = 6;
            this.btnAdvancedSearch.Text = "Advanced search";
            this.btnAdvancedSearch.UseVisualStyleBackColor = true;
            // 
            // lboxActivities
            // 
            this.lboxActivities.FormattingEnabled = true;
            this.lboxActivities.ItemHeight = 16;
            this.lboxActivities.Location = new System.Drawing.Point(12, 42);
            this.lboxActivities.Name = "lboxActivities";
            this.lboxActivities.Size = new System.Drawing.Size(451, 436);
            this.lboxActivities.TabIndex = 0;
            // 
            // lblNameContains
            // 
            this.lblNameContains.AutoSize = true;
            this.lblNameContains.Location = new System.Drawing.Point(484, 26);
            this.lblNameContains.Name = "lblNameContains";
            this.lblNameContains.Size = new System.Drawing.Size(106, 17);
            this.lblNameContains.TabIndex = 7;
            this.lblNameContains.Text = "Name contains:";
            // 
            // lblActivities
            // 
            this.lblActivities.AutoSize = true;
            this.lblActivities.Location = new System.Drawing.Point(16, 22);
            this.lblActivities.Name = "lblActivities";
            this.lblActivities.Size = new System.Drawing.Size(67, 17);
            this.lblActivities.TabIndex = 8;
            this.lblActivities.Text = "Activities:";
            // 
            // MainMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(842, 490);
            this.Controls.Add(this.lblActivities);
            this.Controls.Add(this.lboxActivities);
            this.Controls.Add(this.lblNameContains);
            this.Controls.Add(this.btnAdvancedSearch);
            this.Controls.Add(this.gboxPrice);
            this.Controls.Add(this.gboxParticipants);
            this.Controls.Add(this.gboxAccessibility);
            this.Controls.Add(this.tboxName);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "MainMenu";
            this.Text = "MainMenu";
            this.gboxAccessibility.ResumeLayout(false);
            this.gboxAccessibility.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundAccessibility)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundAccessibility)).EndInit();
            this.gboxParticipants.ResumeLayout(false);
            this.gboxParticipants.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundParticipants)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundParticipants)).EndInit();
            this.gboxPrice.ResumeLayout(false);
            this.gboxPrice.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudUpperboundPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLowerboundPrice)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.ListBox lboxActivities;
        private System.Windows.Forms.TextBox tboxName;
        private System.Windows.Forms.GroupBox gboxAccessibility;
        private System.Windows.Forms.Label lblLowerboundaryAccessibility;
        private System.Windows.Forms.NumericUpDown nudUpperboundAccessibility;
        private System.Windows.Forms.NumericUpDown nudLowerboundAccessibility;
        private System.Windows.Forms.GroupBox gboxParticipants;
        private System.Windows.Forms.NumericUpDown nudUpperboundParticipants;
        private System.Windows.Forms.NumericUpDown nudLowerboundParticipants;
        private System.Windows.Forms.GroupBox gboxPrice;
        private System.Windows.Forms.NumericUpDown nudUpperboundPrice;
        private System.Windows.Forms.NumericUpDown nudLowerboundPrice;
        private System.Windows.Forms.Button btnConfirmAccessibility;
        private System.Windows.Forms.Button btnAdvancedSearch;
        private System.Windows.Forms.Label lblNameContains;
        private System.Windows.Forms.Label lblUpperboundaryAccessibility;
        private System.Windows.Forms.Label lblUpperboundaryParticipants;
        private System.Windows.Forms.Label lblLowerboundaryParticipants;
        private System.Windows.Forms.Label lblUpperboundaryPrice;
        private System.Windows.Forms.Label lblLowerboundaryPrice;
        private System.Windows.Forms.Label lblActivities;
        private System.Windows.Forms.Button btnConfirmParticipants;
        private System.Windows.Forms.Button btnConfirmPrice;
    }
}