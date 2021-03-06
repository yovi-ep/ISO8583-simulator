package com.mpc.ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jpos.iso.ISOBinaryField;
import org.jpos.iso.ISODate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOField;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;

import com.mpc.iso.ISOMux;
import com.mpc.iso.model.Configuration;
import com.mpc.iso.model.HEADER_TYPE;
import com.mpc.iso.model.HeaderConfig;
import com.mpc.iso.services.iChannel;
import com.mpc.iso.services.iConnection;
import com.mpc.iso.services.impl.ConnectionService;
import com.mpc.utils.IOFile;
import javax.swing.SwingConstants;

public class Main implements ChangeListener, ActionListener{
	private ISOMux mux = null;
	private iConnection connectionService;
	private iChannel channel;
	
	/***
	 * Tab Activity
	 */
	private JFrame frmVsim;
	private JTextArea taLogging;
	private JCheckBox cbWrapLine; 
	private JTextField txIP;
	private JTextField txPort;
	private JTextField txHeaderLength;
	private JTextField txHeaderStartValue;
	private JTextField txHeaderMidValue;
	private JTextField txHeaderEndValue;
	private JToggleButton btStart;
	private JComboBox listbxPackager;
	private JComboBox listbxHeaderType;
	private JCheckBox cbCustomHeader;
	private JCheckBox cbMode;
	private JButton btClear;
	private JButton btnSend;
	
	private JCheckBox cbStrestTest;
	/***
	 * Tab Data
	 */
	/***
	 * Data Resopnse
	 */
	private JTextArea txDataResponse;
	private JButton btSaveResponse;
	private JTextField txNumTrx;
	private JTextField txMaxTrx;
	
	/**
	 * Launch the application.
	 * @throws ISOException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ISOException {
		final Main window = new Main();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frmVsim.setVisible(true);
					window.initializeObjectContent();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVsim = new JFrame();
		frmVsim.setFont(new Font("Arial", Font.PLAIN, 11));
		frmVsim.setTitle("VSim");
		frmVsim.setBounds(100, 100, 812, 619);
		frmVsim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVsim.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmVsim.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 558, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLayeredPane tabActivity = new JLayeredPane();
		tabbedPane.addTab("Activity", null, tabActivity, null);
		tabbedPane.setForegroundAt(0, Color.DARK_GRAY);
		tabbedPane.setBackgroundAt(0, SystemColor.activeCaptionBorder);
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_tabActivity = new GroupLayout(tabActivity);
		gl_tabActivity.setHorizontalGroup(
			gl_tabActivity.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
		);
		gl_tabActivity.setVerticalGroup(
			gl_tabActivity.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Connection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txIP = new JTextField();
		txIP.setText("localhost");
		txIP.setFont(new Font("Dialog", Font.PLAIN, 11));
		txIP.setColumns(10);
		txIP.setBounds(66, 23, 103, 20);
		panel.add(txIP);
		
		txPort = new JTextField();
		txPort.setText("8888");
		txPort.setFont(new Font("Dialog", Font.PLAIN, 11));
		txPort.setColumns(10);
		txPort.setBounds(66, 49, 103, 20);
		panel.add(txPort);
		
		cbMode = new JCheckBox("Client mode");
		cbMode.setFont(new Font("Dialog", Font.PLAIN, 11));
		cbMode.setBounds(175, 22, 91, 23);
		cbMode.addChangeListener(this);
		panel.add(cbMode);
		
		JLabel label = new JLabel("IP");
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(14, 26, 31, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Port");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(14, 52, 31, 14);
		panel.add(label_1);
		
		listbxPackager = new JComboBox();
		listbxPackager.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listbxPackager.setBounds(66, 75, 128, 20);
		panel.add(listbxPackager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Header", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 106, 252, 151);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Type :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 26, 42, 14);
		panel_1.add(label_2);
		
		listbxHeaderType = new JComboBox();
		listbxHeaderType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listbxHeaderType.setBounds(56, 23, 69, 20);
		panel_1.add(listbxHeaderType);
		
		cbCustomHeader = new JCheckBox("Custom header");
		cbCustomHeader.setFont(new Font("Arial", Font.PLAIN, 11));
		cbCustomHeader.setBounds(7, 51, 107, 23);
		cbCustomHeader.addChangeListener(this);
		panel_1.add(cbCustomHeader);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(2, 62, 248, 89);
		panel_1.add(panel_2);
		
		txHeaderStartValue = new JTextField();
		txHeaderStartValue.setColumns(10);
		txHeaderStartValue.setBounds(154, 11, 86, 20);
		panel_2.add(txHeaderStartValue);
		
		txHeaderMidValue = new JTextField();
		txHeaderMidValue.setColumns(10);
		txHeaderMidValue.setBounds(154, 32, 86, 20);
		panel_2.add(txHeaderMidValue);
		
		txHeaderEndValue = new JTextField();
		txHeaderEndValue.setColumns(10);
		txHeaderEndValue.setBounds(154, 53, 86, 20);
		panel_2.add(txHeaderEndValue);
		
		JLabel label_3 = new JLabel("End value");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 56, 98, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Mid value");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(10, 35, 98, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Start value");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(10, 14, 98, 14);
		panel_2.add(label_5);
		
		txHeaderLength = new JTextField();
		txHeaderLength.setToolTipText("Header length");
		txHeaderLength.setColumns(10);
		txHeaderLength.setBounds(198, 23, 44, 20);
		panel_1.add(txHeaderLength);
		
		JLabel label_6 = new JLabel("Length:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(147, 26, 50, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Packager");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(14, 78, 46, 14);
		panel.add(label_7);
		
		btStart = new JToggleButton("START");
		btStart.setFont(new Font("Dialog", Font.PLAIN, 11));
		btStart.setBounds(175, 268, 86, 23);
		btStart.addActionListener(this);
		panel.add(btStart);
		
		JScrollPane spLogging = new JScrollPane();
		spLogging.setAlignmentX(2.0f);
		
		taLogging = new JTextArea();
		taLogging.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		taLogging.setFont(new Font("Monospaced", Font.PLAIN, 11));
		taLogging.setEditable(false);
		spLogging.setViewportView(taLogging);
		taLogging.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		taLogging.setBorder(new EmptyBorder(0, 0, 0, 0));
		taLogging.setAutoscrolls(true);
		
		btClear = new JButton("CLEAR");
		btClear.setFont(new Font("Arial", Font.PLAIN, 11));
		btClear.addActionListener(this);
		
		cbWrapLine = new JCheckBox("Line wrap");
		cbWrapLine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbWrapLine.setFont(new Font("Dialog", Font.PLAIN, 11));
		cbWrapLine.addChangeListener(this);
		cbWrapLine.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_4, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
					.addGap(50)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(spLogging, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(cbWrapLine)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btClear)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(btClear, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbWrapLine))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spLogging, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(28)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
		);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		
		cbStrestTest = new JCheckBox("Stresttest");
		
		txNumTrx = new JTextField();
		txNumTrx.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Num Trx");
		
		JLabel lblPersecond = new JLabel("persecond");
		lblPersecond.setHorizontalAlignment(SwingConstants.LEFT);
		
		txMaxTrx = new JTextField();
		txMaxTrx.setColumns(10);
		
		JLabel lblMaxTrx = new JLabel("Max Trx");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addComponent(cbStrestTest)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
									.addComponent(lblMaxTrx, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txNumTrx, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
									.addComponent(txMaxTrx, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
								.addGap(5)
								.addComponent(lblPersecond, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGap(22)
								.addGap(50)))
						.addComponent(btnSend, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbStrestTest)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(txMaxTrx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxTrx))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(txNumTrx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPersecond)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnSend))
		);
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(gl_panel_3);
		tabActivity.setLayout(gl_tabActivity);
		
		JTabbedPane tabDataConfig = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Data", null, tabDataConfig, null);
		
		JPanel panelResponse = new JPanel();
		tabDataConfig.addTab("Response", null, panelResponse, null);
		
		btSaveResponse = new JButton("Save");
		btSaveResponse.addActionListener(this);
		JScrollPane spDataResponse = new JScrollPane();
		GroupLayout gl_panelResponse = new GroupLayout(panelResponse);
		gl_panelResponse.setHorizontalGroup(
			gl_panelResponse.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelResponse.createSequentialGroup()
					.addContainerGap()
					.addComponent(btSaveResponse, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addComponent(spDataResponse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
		);
		gl_panelResponse.setVerticalGroup(
			gl_panelResponse.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelResponse.createSequentialGroup()
					.addComponent(spDataResponse, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btSaveResponse)
					.addGap(4))
		);
		
		txDataResponse = new JTextArea();
		spDataResponse.setViewportView(txDataResponse);
		panelResponse.setLayout(gl_panelResponse);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Data", null, layeredPane, null);
		frmVsim.getContentPane().setLayout(groupLayout);
	}

	private void initializeObjectContent() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				initTabActivityContent();
				initTabDataContent();
			}
		}).start();
	}
	
	/***
	 * Init tab activity content
	 */
	private void initTabActivityContent() {
		/***
		 * Get list file packager
		 */
		File files[] = IOFile.getFiles(new File("iso/"), null);
		listbxPackager.addItem(AppConstants.TAG_DEFAULT);
		for(File f : files)
			listbxPackager.addItem(f.getName());
		
		/***
		 * List header type
		 */
		for(HEADER_TYPE h : HEADER_TYPE.values()) {
			listbxHeaderType.addItem(h.name());
		}
		
		/***
		 * Disable custom header : default
		 */
		setEnableCustomHeader(false);
		
		/***
		 * Set text area logger
		 */
		UILogAppenderListener.setTextArea(taLogging);
		
		/***
		 * Create objek
		 */
		connectionService = new ConnectionService();
	}
	
	/***
	 * Init tab data content
	 */
	private void initTabDataContent() {
		txDataResponse.setText(IOFile.ReadFile(AppConstants.FILE_DATA_RESPONSE));
	}
	
	public Configuration getConfiguration() throws ISOException {
		Configuration config = new Configuration();
		HeaderConfig header = getHeaderConfit();
		
		if(cbMode.isSelected()) {
			config.setIp("");
		}else {
			config.setIp(txIP.getText());
		}
		
		config.setPort(Integer.parseInt(txPort.getText()));
		config.setCustomPackager(listbxPackager.getSelectedItem().toString().replace(AppConstants.TAG_DEFAULT, ""));
		config.setHeaderConfig(header);
		return config;
	}
	
	private HeaderConfig getHeaderConfit() {
		HeaderConfig header = new HeaderConfig();
		header.setHeaderType(HEADER_TYPE.valueOf(listbxHeaderType.getSelectedItem().toString()));
		header.setHeaderLength(Integer.parseInt(txHeaderLength.getText()));
		if(cbCustomHeader.isSelected()) {
			header.setStartValue(txHeaderStartValue.getText());
			header.setMiddleValue(txHeaderMidValue.getText());
			header.setEndValue(txHeaderEndValue.getText());
		}else {
			header.setStartValue("");
			header.setMiddleValue("");
			header.setEndValue("");
		}
		return header;
	}
	
	private void setEnableCustomHeader(boolean isSelected) {
		txHeaderStartValue.setEnabled(isSelected);
		txHeaderMidValue.setEnabled(isSelected);
		txHeaderEndValue.setEnabled(isSelected);		
	}
	
	private void saveDataResponse() {
		Object[] options = {"Ya","Tidak"};
		int n = JOptionPane.showOptionDialog(null,
		    "Apakah anda benar ingin simpan data response?",
		    "Save", JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[0]);
		if(n == 0) {
			IOFile.WriteFile(AppConstants.FILE_DATA_RESPONSE, "", txDataResponse.getText(), "", false);
			initTabDataContent();
		}
	}
	
	/***
	 * Action Listener 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JToggleButton) 
		{
			JToggleButton btTogle = (JToggleButton) obj;
			if(btTogle.equals(btStart)) 
			{
				
				if(btTogle.isSelected()) {
					Configuration config = null;
					try {
						config = getConfiguration();
					} catch (ISOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mux = connectionService.start(config);
				}else {
					System.out.println(channel + " close");
					if(mux != null) {
						connectionService.stop(mux);
					}
				}
			}
		}else if(obj instanceof JButton) {
			JButton button = (JButton) obj;
			if(button.equals(btClear)) {
				taLogging.setText("");
			}else if(button.equals(btSaveResponse)) {
				saveDataResponse();
			}else if(button.equals(btnSend)) {
				btSendAction();
			}
		}
	}
	
	/***
	 * Button Send Action 
	 */
	public void btSendAction() {
		if(cbStrestTest.isSelected()) {
			final int maxTrx = Integer.parseInt(txMaxTrx.getText());
			final int numTrx = Integer.parseInt(txNumTrx.getText());
			new Thread(new Runnable() {
				public void run() {
					for(int i= 1; i <= maxTrx; i+=numTrx) {
						for(int j= 1; j <= numTrx; j++) {
							sendMessage();
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}else {
			sendMessage();
		}
	}
	
	private void sendMessage() {
		ISOMsg iso = new ISOMsg();
		try {
			//TODO sequence trace
			Date d = new Date();
			long mls = d.getTime();
			long trace = mls % 1000000;
			String traceNumber = ISOUtil.zeropad(String.valueOf(trace), 6);
			
			iso.setMTI("0200");
			iso.set(new ISOField(2, "6274921575008589"));
			iso.set(new ISOField(3, "810071"));
			iso.set(new ISOField(4, "10"));
			iso.set(new ISOField(7, ISODate.getDateTime(d)));		
			iso.set(new ISOField(11, traceNumber));
			iso.set(new ISOField(18,"6012"));
			iso.set(new ISOField(22,"121"));
			iso.set(new ISOField(32,"627492"));
			iso.set(new ISOField(33,"627492"));
			iso.set(new ISOField(35,"6274921575008589=18030000006"));
			iso.set(new ISOField(37,ISODate.getDateTime(d).substring(0, 6)+""+traceNumber));
			iso.set(new ISOField(41,"VSIM0003"));
			iso.set(new ISOField(42,"CO.MLPT"));
			iso.set(new ISOField(48,"0082285398884"));
			iso.set(new ISOField(49,"360"));
			iso.set(new ISOBinaryField(52, ISOUtil.hex2byte("2BF438AC0E4B53F8")));
			mux.send(iso);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/****
	 * CheckBox State Change listener
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JCheckBox) {
			JCheckBox cb = (JCheckBox) obj;
			if(cb.equals(cbWrapLine)) {
				taLogging.setLineWrap(cb.isSelected());
			}else if(cb.equals(cbMode)){
				if(cbMode.isSelected()) {
					cbMode.setText("Server mode");
					txIP.setEnabled(false);
				}else {
					cbMode.setText("Client mode");
					txIP.setEnabled(true);
				}
			}else if(cb.equals(cbCustomHeader)) {
				setEnableCustomHeader(cb.isSelected());
			}
		}
	}
}
