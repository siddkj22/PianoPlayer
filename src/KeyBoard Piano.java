package spian;

import javax.swing.*;
import javax.sound.midi.*;

import java.awt.event.*;

	public class k1 implements KeyListener{

		public void gui(){
			JFrame a = new JFrame("KeyPiano");
			//JTextField field = new JTextField();
			
			JTextArea text = new JTextArea();
		
			//field.addKeyListener(this);
		
			text.addKeyListener(this);
			
			//a.getContentPane().add(field);
			
			a.getContentPane().add(text);
			a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			a.setVisible(true);
			a.setSize(800,500);
		}
		
		public void play(int note){
			try{
				Sequencer player = MidiSystem.getSequencer();
				player.open();
				Sequence seq = new Sequence(Sequence.PPQ,4);
				Track track = seq.createTrack();
				
				ShortMessage a = new ShortMessage();
				a.setMessage(144,1,note,100);
				MidiEvent noteon = new MidiEvent(a,1);
				track.add(noteon);
				
				ShortMessage b = new ShortMessage();
				b.setMessage(128,1,note,100);
				MidiEvent noteoff = new MidiEvent(b,1);
				track.add(noteoff);
				
				player.setSequence(seq);
				player.start();
		
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.print("error");
			}
		}

		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.print("yes k i s pressesdd");
			
			//spia.play();
			//System.out.print("yes e was released");
			//int nt =(int)( Math.random()*120);
			//play(nt);
			
		}

		public void keyReleased(KeyEvent arg0) {
			int nt =(int)( Math.random()*120);
			play(nt);
			
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.print("yes n was typeds");
			//System.out.print("yes e was released");
			//int nt =(int)( Math.random()*120);
			//play(nt);
			
		}
		
		public static void main(String[] args){
			k1 spia = new k1();
			spia.gui();

			
		}

		
	}