import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


class Game extends JFrame{
    JLabel computerChoice,result,playerChoice,computerScore,PlayerScore, backgroundImage, startImage;
    int player_score=0;
    int computer_score=0;

    ImageIcon image_rock, image_paper, image_scissor, image_win, image_loss, image_draw, bg, start;
    public void setup(){
        start = new ImageIcon(new ImageIcon("assets/RPS.png").getImage()
                                    .getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        bg = new ImageIcon(new ImageIcon("assets/bg1.png").getImage()
                                    .getScaledInstance(600, 400, Image.SCALE_DEFAULT));

        image_rock = new ImageIcon(new ImageIcon("assets/Rock.png").getImage()
                                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        image_paper = new ImageIcon(new ImageIcon("assets/Paper.png").getImage()
                                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        image_scissor = new ImageIcon(new ImageIcon("assets/Scissor.png").getImage()
                                    .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        image_win = new ImageIcon(new ImageIcon("assets/win.png").getImage()
                                    .getScaledInstance(220, 150, Image.SCALE_DEFAULT));

        image_loss = new ImageIcon(new ImageIcon("assets/lose.png").getImage()
                                    .getScaledInstance(220, 150, Image.SCALE_DEFAULT));

        image_draw = new ImageIcon(new ImageIcon("assets/Draw.png").getImage()
                                    .getScaledInstance(220, 150, Image.SCALE_DEFAULT));


        backgroundImage = new JLabel();
        backgroundImage.setIcon(bg);
        backgroundImage.setBounds(0,0,600,400);

        startImage = new JLabel();
        startImage.setIcon(start);
        startImage.setHorizontalTextPosition(JLabel.CENTER);
        startImage.setVerticalTextPosition(JLabel.BOTTOM);
        startImage.setBounds(230,80,150,150);

        computerScore = new JLabel();
        computerScore.setText("Computer : 0");
        computerScore.setBounds(45,0,200,100);
        computerScore.setFont(new Font("Arial", Font.BOLD, 22));

        PlayerScore = new JLabel();
        PlayerScore.setText("Player : 0");
        PlayerScore.setBounds(449,0,150,100);
        PlayerScore.setFont(new Font("Arial", Font.BOLD, 22));

        computerChoice = new JLabel();
        computerChoice.setHorizontalTextPosition(JLabel.CENTER);
        computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
        computerChoice.setBounds(60,130,150,150);
        computerChoice.setForeground(Color.white);
        computerChoice.setFont(new Font("Arial", Font.BOLD, 19));

        playerChoice = new JLabel();
        playerChoice.setHorizontalTextPosition(JLabel.CENTER);
        playerChoice.setVerticalTextPosition(JLabel.BOTTOM);
        playerChoice.setBounds(450,130,150,150);
        playerChoice.setForeground(Color.white);
        playerChoice.setFont(new Font("Arial", Font.BOLD, 19));

        result = new JLabel();
        result.setHorizontalTextPosition(JLabel.CENTER);
        result.setVerticalTextPosition(JLabel.BOTTOM);
        result.setBounds(200,50,250,200);



        JLabel label_rock = new JLabel();
        label_rock.setText("Rock");
        label_rock.setIcon(image_rock);
        label_rock.setHorizontalTextPosition(JLabel.CENTER);
        label_rock.setVerticalTextPosition(JLabel.BOTTOM);
        label_rock.setBounds(170,260,100,120);
        label_rock.setForeground(Color.white);
        label_rock.setFont(new Font("Arial", Font.BOLD, 19));

        JLabel label_paper = new JLabel();
        label_paper.setText("Paper");
        label_paper.setIcon(image_paper);
        label_paper.setHorizontalTextPosition(JLabel.CENTER);
        label_paper.setVerticalTextPosition(JLabel.BOTTOM);
        label_paper.setBounds(270,260,100,120);
        label_paper.setForeground(Color.white);
        label_paper.setFont(new Font("Arial", Font.BOLD, 19));

        JLabel label_scissor = new JLabel();
        label_scissor.setText("Scissor");
        label_scissor.setIcon(image_scissor);
        label_scissor.setHorizontalTextPosition(JLabel.CENTER);
        label_scissor.setVerticalTextPosition(JLabel.BOTTOM);
        label_scissor.setBounds(370,260,100,120);
        label_scissor.setForeground(Color.white);
        label_scissor.setFont(new Font("Arial", Font.BOLD, 19));


        label_rock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(label_rock.getText());
            }
        });

        label_paper.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(label_paper.getText());
            }
        });

        label_scissor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(label_scissor.getText());
            }
        });

        add(startImage);
        add(label_rock);
        add(label_paper);
        add(label_scissor);
        add(computerChoice);
        add(result);
        add(computerScore);
        add(playerChoice);
        add(PlayerScore);
        add(backgroundImage);
        setLayout(null);
    }

    public void calculate(String player){
        String[] list = {"Rock", "Paper", "Scissor"};
        int random_choice = (int)((Math.random()*10)%3);
        String computer = list[random_choice];

        computerChoice.setText(computer);
        if(random_choice==0){
            computerChoice.setIcon(image_rock);
        }
        else if(random_choice==1){
            computerChoice.setIcon(image_paper);
        }
        else{
            computerChoice.setIcon(image_scissor);
        }


        if(player.equals(computer)){
            result.setIcon(image_draw);
        }
        else if(player.equals("Rock")){
            if(computer.equals("Paper")){
                result.setIcon(image_loss);
                computer_score++;
            }
            else{
                result.setIcon(image_win);
                player_score++;
            }
        }
        else if(player.equals("Paper")){
            if(computer.equals("Scissor")){
                result.setIcon(image_loss);
                computer_score++;
            }
            else{
                result.setIcon(image_win);
                player_score++;
            }
        }
        else{
            if(computer.equals("Rock")){
                result.setIcon(image_loss);
                computer_score++;
            }
            else{
                result.setIcon(image_win);
                player_score++;
            }
        }
        PlayerScore.setText("Player : "+player_score);
        computerScore.setText(("Computer : "+computer_score));

        if(player=="Rock"){
            playerChoice.setIcon(image_rock);
            playerChoice.setText("Rock");
            startImage.setVisible(false);
        }
        else if(player=="Paper"){
            playerChoice.setIcon(image_paper);
            playerChoice.setText("Paper");
            startImage.setVisible(false);
        }
        else{
            playerChoice.setIcon(image_scissor);
            playerChoice.setText("Scissor");
            startImage.setVisible(false);
        }
    }


    public static void main(String[] args){
        Game G = new Game();
        G.setTitle("Rock Paper Scissor");
        G.setBounds(200,200,600,435);
        G.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        G.setup();
        G.getContentPane().setBackground(Color.WHITE);
        G.setResizable(false);
        G.setVisible(true);
    }
}







